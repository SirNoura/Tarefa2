let map;

// Initialize and add the map
function initMap() {
    
  // The location of Braga
  const braga = { lat: 41.494598, lng: -8.4423057 };
    
  // The map, centered at Braga
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 13,
    center: braga,
  });
    
  // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: braga,
    map: map,
  });
  getLocation();
}

function getValues() {
     getLocation();
}
    
function getLocation() {
        
     if (navigator.geolocation) {
         navigator.geolocation.getCurrentPosition(showPosition);
     } else {
         window.alert("Geolocation is not supported by this browser."); 
     }
    }
function showPosition(position) {
     window.alert("Latitude: " + position.coords.latitude +  "<br>Longitude: " + position.coords.longitude); 
    const braga = { lat: position.coords.latitude, lng: position.coords.longitude };
    const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 13,
    center: braga,
  });
    // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: braga,
    map: map,
  }); 
    document.getElementById("btnOK").value = position.coords.latitude;
}
