import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Controller | convertir', function(hooks) {
  setupTest(hooks);

  // Replace this with your real tests.
  test('it exists', function(assert) {
    let controller = this.owner.lookup('controller:convertir');
    assert.ok(controller);
  });

  test('10 a Romano', function(assert) {
    let controller = this.owner.lookup('controller:convertir');
    controller.send('convertirToRomano', 10);
    assert.equal(controller.get("resultado"), 'X');
  });

  test('101 a Romano no se puede', function(assert) {
    let controller = this.owner.lookup('controller:convertir');
    controller.send('convertirToRomano', 101);
    assert.equal(controller.get("resultado"), '');
  });
});
