// Include http ,url module.
var http = require("http");
var url = require("url");
// Create http server.
var httpServer = http.createServer(function (req, resp) {
  // Get client request url.
  var reqUrlString = req.url;
  // Get client request path name.
  var pathName = url.parse(reqUrlString, true, false).pathname;
  // If request login action.
  if ("/post" == pathName) {
    // Get request method.
    var method = req.method;
    // If post.
    if ("POST" == method) {
      var postData = "";
      // Get all post data when receive data event.
      req.on("data", function (chunk) {
        postData += chunk;
      });
      // When all request post data has been received.
      req.on("end", function () {
        console.log("Client post data : " + postData);
        resp.writeHead(200, { "Access-Control-Allow-Origin": "*" });
        resp.end('');
      });
    }
  }
});
// Http server listen on port 8888.
httpServer.listen(8888);
console.log("Server is started.");
