
function upload(){
	var canvas = document.getElementsById("d1");
	var fileinput = document.getElementsById("finput");

	var sImg = new SimpleImage(fileinput);
	sImg.drawTo(canvas);
}