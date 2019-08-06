import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | route-hotel', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:route-hotel');
    assert.ok(route);
  });
});
