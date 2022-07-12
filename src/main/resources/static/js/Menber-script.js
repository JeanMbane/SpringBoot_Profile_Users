

	/* When the user clicks on the button, 
	 toggle between hiding and showing the dropdown content */
	function myFunction() {

		if (document.getElementById("myDropdown"))

		{
			document.getElementById("myDropdown").classList.toggle("show");

		}

	}

	function myFunction1() {

		if (document.getElementById("myDropdown1")) 
		{
			document.getElementById("myDropdown1").classList.toggle("show");

		}

	}


	// Close the dropdown if the user clicks outside of it

	window.onclick = function(event) {
		if (!event.target.matches('.nav-link1')) {
			var dropdowns = document.getElementsByClassName("dropdown-menu1");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
		} else {
			if (!event.target.matches('.nav-link')) {
				var dropdowns = document
						.getElementsByClassName("dropdown-menu");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}
		
		if (!event.target.matches('.nav-link') || event.target.matches('.nav-link1')) {
			var dropdowns = document.getElementsByClassName("dropdown-menu");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
			
		} else if (!event.target.matches('.nav-link1') || event.target.matches('.nav-link')) {
			var dropdowns = document.getElementsByClassName("dropdown-menu1");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
		}

	}
