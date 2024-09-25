function doChange() {
	alert('clicked button with JS button');
}

function ChangeColor() {
	var dd1 = document.getElementById("d1");
	var dd2 = document.getElementById("d2");

	dd1.className = "blueback";
	dd2.className = "yellowback";
}

function ChangeText() {
	var dd1 = document.getElementById("d1");
	var dd2 = document.getElementById("d2");

	dd1.innerHTML = "Bonjour";
	dd2.innerHTML = "Sayonara";
}