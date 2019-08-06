var express         = require("express"),
    app             = express(),
    bodyParser      = require("body-parser"),
    methodOverride  = require("method-override")




const port = process.env.PORT || 5000;

// Middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(methodOverride());

var codebreaker = require('./controllers/codebreaker');

var cb = express.Router();

cb.route('/adivinarsecreto/:secret')
  .get(codebreaker.adivinarSecreto);

cb.route('/setsecreto')
  .post(codebreaker.setSecret);

app.use(cb);
// Start server
var server = app.listen(port, function() {
  console.log("Node server running on "+ port);
});
module.exports = server;