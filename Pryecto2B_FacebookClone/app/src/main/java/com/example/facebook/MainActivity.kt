package com.example.facebook

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val publicaciones = listOf(
            Publicacion("https://scontent.fuio13-1.fna.fbcdn.net/v/t1.6435-9/192039004_1163894254074931_5190518940606839627_n.jpg?stp=dst-jpg_p843x403&_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeElRf-EPatWjgw2cPXN6Pzp0zRgdPxmYqvTNGB0_GZiqyp0UvmB3DuduesE7PUckthe7VxEtJFMMKyc5f9O5Ip_&_nc_ohc=zvEfVtr6NAoAX9kI-Ei&_nc_ht=scontent.fuio13-1.fna&oh=00_AfAV8bgx0O3273g7dlmYw3fRFGlzl4Kc74Ylcl4btND6og&oe=641DBE29",
                "Para los que no creían en nosotros REGRESAMOS \uD83C\uDFA4\uD83C\uDFA4\uD83C\uDFA4\uD83C\uDFA4 y vamos con más fuerza, Gracias Señor porque siempre nos pones hombres de Dios en nuestro camino bendecimos  su vida Pastor Diego Reinoso DIOS ES BUENO.",
                ContextCompat.getDrawable(this, R.drawable.usuario1)!!,
                "Pablo Velez",
                "\uD83D\uDC4D\uD83C\uDFFB 30                                                    10 comentarios"),
            Publicacion("https://scontent.fuio13-1.fna.fbcdn.net/v/t39.30808-6/271599537_465088985082031_6703811429738458926_n.jpg?stp=dst-jpg_p843x403&_nc_cat=110&ccb=1-7&_nc_sid=8bfeb9&_nc_eui2=AeH98lcEC0nPKRs5D2GKfTEB2Udblhvz6NHZR1uWG_Po0S_BCXH9xL8dVn0Kb5qzyMEn5FovMPxpMv7S8PdCJ20a&_nc_ohc=7Rr2b-oMAQAAX-Af348&_nc_ht=scontent.fuio13-1.fna&oh=00_AfDjdtiVD-3n-fBVsQllQCwEuH90t-uVZpfW4ACr_xCwTQ&oe=63FB5A93",
                "Patitas\uD83D\uDC3E \uD83C\uDF39",
                ContextCompat.getDrawable(this, R.drawable.usuario2)!!,
                "Alisson Avila",
                "\uD83D\uDC4D\uD83C\uDFFB 25                                                    40 comentarios"),
            Publicacion("https://scontent.fuio13-1.fna.fbcdn.net/v/t39.30808-6/330610352_3417519741899412_5868415262598276850_n.jpg?stp=dst-jpg_p843x403&_nc_cat=102&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeGhpmryo3om4wymAzym1y0GVSLUF4v5VNxVItQXi_lU3NqTatPvxK-CLIngJdfP8uonuZjbdhAUV3_0h32TtrjJ&_nc_ohc=7oVam7cat-EAX_nxqcc&_nc_ht=scontent.fuio13-1.fna&oh=00_AfBQa5Bjx7boCz9q5hoXsmVky5lW6a977MhIWGMlm1ukqA&oe=63FAF960",
                "Hoy Solo pa Jóvenes \uD83C\uDF89\uD83C\uDF89\uD83C\uDF89",
                ContextCompat.getDrawable(this, R.drawable.usuario3)!!,
                "Diego Reinoso",
                "\uD83D\uDC4D\uD83C\uDFFB 40                                                    5 comentarios"),
            Publicacion("https://scontent.fuio13-1.fna.fbcdn.net/v/t39.30808-6/326546673_1318207995627473_8450460450376320414_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeFeb4G3RpvP-nTipOPDrWRtPmw_zT56g5c-bD_NPnqDl-TBs3c00H0YdOZKct1JG-WrMzMpb1zxGOyyJAI18DtM&_nc_ohc=ssgJeUlbvTgAX-64ruk&_nc_ht=scontent.fuio13-1.fna&oh=00_AfBC-ll259CYcNuJy2EfeTnoM4REftwAlux1wSXx81aWbA&oe=63FAF54D",
                "Kevin Vélez amor nunca olvides todas las promesas que Dios te da por medio de sus hijos gracias Pastor Israel  y Ma Fernanda Obando seguimos adelante sembraron en tierra fértil",
                ContextCompat.getDrawable(this, R.drawable.usuario4)!!,
                "Kevin Velez",
                "1357 M de visitas")
        )

        val recyclerView: RecyclerView = findViewById(R.id.publicacion_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PublicacionAdapter(publicaciones, this)
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()


    }

}