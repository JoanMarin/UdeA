import DS from 'ember-data';

export default DS.Model.extend({
  fontSize: DS.attr('number'),
  lastLogin: DS.attr('number'),
  theme: DS.attr('string')
});
