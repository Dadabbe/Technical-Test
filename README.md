# TT
Technical Test done in Kotlin for X. The aim of the project is to retrieve a list of locations/dates couples from a JSON file then display it in an Android app.

Done using a RecyclerView to contain the data, Geocoder to get addresses from longitude and latitude. Requires API 24+ to execute some functions.
The recyclerview can struggle a bit if you scroll too fast mostly because Geocoder calls are a bit slow, but otherwise, all functions are working fine.
