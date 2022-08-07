package com.example.businesscard.data

data class UserData(var userName: String = "",
                    var carInfo: CardDetails = CardDetails(),
                    var email: String = "",
                    var nameSurname: String = "",
//                    var URL: String = ""
)