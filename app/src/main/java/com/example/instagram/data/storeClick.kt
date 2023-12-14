package com.example.instagram.data


import com.google.firebase.database.FirebaseDatabase

fun storeClick(id: Int, clicks: Int = 1) {
    // Obtén la referencia a la tabla
    val clicksRef = FirebaseDatabase.getInstance().getReference("clicks")

    // Convierte el id a cadena y actualiza el valor de los clics
    clicksRef.child(id.toString()).setValue(clicks)
}