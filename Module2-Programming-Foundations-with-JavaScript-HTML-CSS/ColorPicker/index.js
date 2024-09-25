function doColor() {
	var dd1 = document.getElementById("d1");
	var colorInput = document.getElementById("clr");
	var color = colorInput.value;

	dd1.style.backgroundColor= color;
}

function doYellow() {
	var dd1 = document.getElementById("d1");
	dd1.style.backgroundColor = "white";

	var ctx =dd1.getContext("2d");

	ctx.fillStyle ="yellow";
	ctx.fillRect(10,10,40,40);
	ctx.fillRect(60,10,40,40);

	ctx.fillStyle="black";
	ctx.font = "30px Ariel";
	ctx.fillText("Hello", 10,80);
}

function doSquare() {
	var dd1 = document.getElementById("d1");
	var sizeInput = document.getElementById("sldr");

	var size = sizeInput.value;

	var context = dd1.getContext("2d");
	context.clearRect(0,0,dd1.width,dd1.height);

	context.fillStyle = "yellow";
	context.fillRect(10,10,size,size);
}