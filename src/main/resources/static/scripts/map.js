function initMap() {
    if (!window.google || !window.google.maps) {
        console.error('Google Maps API is not available.');
        return;
    }

    const mapElement = document.getElementById('map');
    const trailId = mapElement.dataset.trailId;

    fetch(`/api/trails/${trailId}/checkpoints`)
        .then(response => response.json())
        .then(checkpoints => {
            if (checkpoints.length === 0) {
                console.error('No checkpoints found.');
                return;
            }

            const map = new google.maps.Map(mapElement, {
                zoom: 8,
                // Initially center the map on the first checkpoint
                center: new google.maps.LatLng(checkpoints[0].coordinates[0], checkpoints[0].coordinates[1])
            });

            const bounds = new google.maps.LatLngBounds();
            checkpoints.forEach(function(checkpoint) {

                const position = new google.maps.LatLng(checkpoint.coordinates[0], checkpoint.coordinates[1]);
                bounds.extend(position);
                new google.maps.Marker({
                    position: position,
                    map: map,
                    title: checkpoint.name // Assuming there's a 'name' property
                });
            });

            // Adjust the map view to fit all the markers
            map.fitBounds(bounds);
        })
        .catch(error => console.error('Error fetching checkpoint data:', error));
}

// Make initMap globally available
window.initMap = initMap;
