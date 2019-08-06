import { module, test } from 'qunit';
import { setupRenderingTest } from 'ember-qunit';
import { render } from '@ember/test-helpers';
import hbs from 'htmlbars-inline-precompile';

module('Integration | Component | login-component', function(hooks) {
  setupRenderingTest(hooks);

  test('it renders', async function(assert) {
    // Set any properties with this.set('myProperty', 'value');
    // Handle any actions with this.set('myAction', function(val) { ... });

    await render(hbs`{{login-component}}`);

    assert.equal(this.element.textContent.trim(), 'Iniciar sesión con Google');

    // Template block usage:
    await render(hbs`
      {{#login-component}}
      {{/login-component}}
    `);

    assert.equal(this.element.textContent.trim(), 'Iniciar sesión con Google');
  });
});
