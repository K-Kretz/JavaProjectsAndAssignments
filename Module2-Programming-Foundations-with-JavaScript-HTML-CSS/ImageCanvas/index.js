function upload(){

var canvas = document.getElementById("d1");
var fileimage = document.getElementById("finput");

var simpleimage = new SimpleImage(fileimage);
simpleimage.drawTo(canvas);
}
