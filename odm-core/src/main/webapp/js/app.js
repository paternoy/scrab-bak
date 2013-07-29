var app = app || {}; // create namespace for our app
// Models
Variable = Backbone.Model.extend({
	urlRoot : '/odm-core/api/variables/',
	defaults : {
		name : '',
		code : 'NOCODE'
	}
});

VariableCollection = Backbone.Collection.extend({
	model : Variable,
	url : "/odm-core/api/variables/"
});

var list = new VariableCollection();

// renders individual todo items list (li)
VariableView = Backbone.View.extend({
	tagName : 'div',
	template : _.template($('#variable-template').html()),
	render : function() {
		this.$el.html(this.template(this.model.toJSON()));
		this.input = this.$('.edit-field');
		return this; // enable chained calls
	},
	initialize : function() {
		this.model.on('change', this.render, this);
		this.model.on('destroy', this.remove, this);
	},
	events : {
		'dblclick label' : 'edit',
		'keypress .edit-field' : 'updateOnEnter',
		'blur .edit-field' : 'close',
		'click .destroy' : 'destroy',
		'click .edit' : 'edit'

	},
	edit : function() {
		this.$el.addClass('editing');
		this.input.focus();
	},
	updateOnEnter : function(e) {
		if (e.which == 13) {
			this.close();
		}
	},
	close : function() {
		var value = this.input.val().trim();
		if (value) {
			this.model.save({
				name : value
			});
		}
		this.$el.removeClass('editing');
	},
	destroy : function() {
		this.model.destroy();
	}
});

AppView = Backbone.View.extend({
	el : '#variableapp',
	initialize : function() {
		this.render();
		this.input = this.$('#new-variable');
		list.on('add', this.addAll, this);
		list.on('reset', this.addAll, this);
		list.fetch();
	},
	events : {
		'keypress #new-variable' : 'createVariableOnEnter'
	},
	createVariableOnEnter : function(e) {
		if (e.which !== 13 || !this.input.val().trim()) { // ENTER_KEY = 13
			return;
		}
		list.create(this.newAttributes());
		this.input.val(''); // clean input box
	},
	addOne : function(variable) {
		var view = new VariableView({
			model : variable
		});
		$('#variable-list').append(view.render().el);
	},
	addAll : function() {
		this.$('#variable-list').html(''); // clean the list
		list.each(this.addOne, this);
	},
	newAttributes : function() {
		return {
			name : this.input.val().trim()
		}
	}

});

DataView = Backbone.View.extend({
	el : '#datavaluesapp',
	initialize : function() {
		this.render();
	},
	events : {
		'click .generate' : 'generate'
	},
	generate:function() {
	    var _this = this;
	    $.ajax({
	        url: '/odm-core/api/datavalues/generate?variableCode=VAR02',
	        success: function() {
	            _this.render();
	        }
	    });
	}

});

// --------------
// Initializers
// --------------

app.appView = new AppView();
app.dataView = new DataView();
