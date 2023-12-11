function search() {
    var input, filter, trailContainer, trailList, trailDetails, trailName, i, txtValue;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    trailContainer = document.querySelector(".trail-container");
    trailList = trailContainer.getElementsByClassName("trail-details");

    for (i = 0; i < trailList.length; i++) {
        trailDetails = trailList[i];
        trailName = trailDetails.querySelector("p:first-child span");
        txtValue = trailName.textContent || trailName.innerText;

        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            trailDetails.style.display = "";
        } else {
            trailDetails.style.display = "none";
        }
    }
}

function filterByLocation() {
    var locationFilter = document.getElementById("filter");
    var selectedLocation = locationFilter.value;
    var trailContainer = document.querySelector(".trail-container");
    var trailList = trailContainer.getElementsByClassName("trail-details");

    for (var i = 0; i < trailList.length; i++) {
        var trail = trailList[i];
        var trailLocation = trail.querySelector("p:nth-child(2) span").textContent.trim();

        //debugging
        // console.log("Selected Location:", selectedLocation);
        // console.log("Trail Location:", trailLocation);

        if (selectedLocation === "all" || trailLocation === selectedLocation) {
            trail.style.display = "";
        } else {
            trail.style.display = "none";
        }
    }
}
