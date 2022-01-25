package com.example.tt_invoxia.model

data class AddressModel (
    var address : String? = null,
    var city : String? = null,
    var state : String? = null,
    var country : String? = null,
    var postalCode : Int? = null,
    var knownName : String
)