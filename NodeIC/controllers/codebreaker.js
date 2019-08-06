
// //GET - Return all tvshows in the DB
// exports.findAllTVShows = function(req, res) {
// 	TVShow.find(function(err, tvshows) {
//     if(err) res.send(500, err.message);

//     console.log('GET /tvshows')
// 		res.status(200).jsonp(tvshows);
// 	});
// };

var cb=require('../domain/cb');

//GET - Return a TVShow with specified ID
exports.adivinarSecreto = function(req, res) {
    var data =  cb.cb(req.params.secret);
    return res.status(200).send(data);
};

exports.setSecret = function(req,res) {
    cb.setSecret(req.body.secret);
    return res.status(200).send("OK");
};
