package com.example.practica_intermedia

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica_intermedia.adapter.AdaptadorDiscos
import com.example.practica_intermedia.databinding.DiscosLayoutBinding
import com.example.practica_intermedia.model.Disco

/*
    Esta clase es la segunda activity, en la que se recibirá en 'nombreRecuperado' el nombre
    del grupo y se mostraran sus discos según este. El resto de funcionalidades son similares
    a las de MainActivity
 */
class DiscosActivity : AppCompatActivity() {
    private lateinit var binding: DiscosLayoutBinding
    private lateinit var discos: ArrayList<Disco>
    private lateinit var adaptadorDiscos: AdaptadorDiscos
    private lateinit var nombreRecuperado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiscosLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // recepciono datos
        nombreRecuperado = intent.extras?.getString("nombre","DEFAULT") ?: "defecto"
        Log.v("prueba_comunicacion: ",nombreRecuperado)
        personalizarRecycer()
    }

    fun personalizarRecycer(){

        discos = ArrayList()
        when (nombreRecuperado) {
            "ColdPlay" -> {
                discos.add(Disco("Parachutes", "ColdPlay", "Capitol Records", 2000, "https://img.discogs.com/4jwEExOZJ_tCj_AmLWJ-ou1JbNk=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-369337-1314899458.jpeg.jpg"))
                discos.add(Disco("A Rush of Blood to the Head", "ColdPlay", "Capitol Records", 2002, "https://img.discogs.com/wRTY_BSKTLinXhwF7qPT7azg0XQ=/fit-in/600x607/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-8619519-1465279370-1232.jpeg.jpg"))
                discos.add(Disco("X&Y", "ColdPlay", "Capitol Records", 2008, "https://static-eu.insales.ru/images/products/1/5162/121001002/large_coldplay-xy.jpg"))
                discos.add(Disco("Mylo Xyloto", "ColdPlay", "Capitol Records", 2011, "https://timeline.coldplay.com/wp-content/uploads/2015/05/coldplay___mylo_xyloto__alternate_album_cover_1__by_rrpjdisc-d7oe37h.jpg"))
                discos.add(Disco("Ghost Stories", "ColdPlay", "Parlophone", 2014, "https://i.pinimg.com/originals/0b/c1/1c/0bc11c3d4cd9e0b8bfbdd3e63ce4e535.png"))
                discos.add(Disco("Everyday Life", "ColdPlay", "Parlophone", 2021, "https://s3.amazonaws.com/media.thecrimson.com/photos/2019/12/23/140257_1341769.jpg"))
            }
            "Red Hot Chili Peppers" -> {
                discos.add(Disco("Californication", "Red Hot Chili Peppers", "Warner", 1999, "https://img.discogs.com/sSR071GiTAYp4XZqeDHCl-2hYgs=/fit-in/600x606/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-6185738-1413200853-4539.jpeg.jpg"))
                discos.add(Disco("By the way", "Red Hot Chili Peppers", "Warner", 2002, "https://i.pinimg.com/originals/1a/0a/b8/1a0ab805b3ed1ce47a113b7fbff54111.jpg"))
                discos.add(Disco("Stadium Arcadium", "Red Hot Chili Peppers", "Warner", 2006, "https://www.mrvinyl.co.za/wp-content/uploads/2017/02/red-hot-chili-pepper-stadium-arcadium.jpg"))
                discos.add(Disco("I'm with You", "Red Hot Chili Peppers", "Warrner", 2011, "https://img.discogs.com/YduN2nnBSXLhTxdyLDwirknVB-4=/fit-in/600x535/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-3103740-1315922505.jpeg.jpg"))
                discos.add(Disco("The Getaway", "Red Hot Chili Peppers", "Warrner", 2016, "https://bloximages.newyork1.vip.townnews.com/heraldstandard.com/content/tncms/assets/v3/editorial/9/d9/9d976ef4-a6ff-5362-8ee0-f056c197c399/576aa73fe9462.image.jpg?resize=1200%2C1111"))
                discos.add(Disco("Unlimited Love", "Red Hot Chili Peppers", "Warrner", 2022, "https://www.alexrox.com/wp-content/uploads/red-hot-chili-peppers-unlimited-love-1.jpg"))
            }
            "The Offspring" -> {
                discos.add(Disco("Smash", "The Offspring", "Epitaph Records", 1994, "https://i.discogs.com/nSLosnYnHELisNH2LpWeqYyDZdsiGyDXZHzBrmnTeuE/rs:fit/g:sm/q:90/h:500/w:500/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTYwOTU4/MTQtMTQxMDk2MTcy/OS02MTQyLmpwZWc.jpeg"))
                discos.add(Disco("Ixnay on the Hombre", "The Offspring", "Columbia Records", 1997, "https://images-na.ssl-images-amazon.com/images/I/71zCwVZ5VrL._SL1200_.jpg"))
                discos.add(Disco("Americana", "The Offspring", "Columbia Records", 1998, "https://alchetron.com/cdn/americana-the-offspring-album-b5b00753-fccf-47ed-94c8-9143b09db07-resize-750.jpeg"))
                discos.add(Disco("Splinter", "The Offspring", "Columbia Records", 2003, "https://imagine-club.com/sites/default/files/styles/product_zoom/public/photos/splinter_offspring_1_lp_columbia_usa_4.jpg?itok=2IlONlhv"))
                discos.add(Disco("Rise and Fall, Rage and Grace", "The Offspring", "Columbia Records", 2008, "https://cdn-s3.allmusic.com/release-covers/500/0000/983/0000983935.jpg"));
                discos.add(Disco("Days Go By", "The Offspring", "Columbia Records", 2012, "https://i5.walmartimages.com/asr/28b4e687-de2b-451b-b0a4-4886e647ac13_1.98fc956e1738f1331cb81f9b3bc9da52.jpeg?odnHeight=450&odnWidth=450&odnBg=ffffff"))
                discos.add(Disco("Let the Bad Times Roll", "The Offspring", "Concord Records", 2021, "https://i0.wp.com/thatsgoodenoughforme.com/wp-content/uploads/2021/04/Let-The-Bad-Times-Roll-The-Offspring.jpg?resize=1024%2C1024&ssl=1"))
            }
            "Papa Roach" -> {
                discos.add(Disco("Infest", "Papa Roach", "DreamWorks Records", 2000, "https://s.ecrater.com/stores/349057/5ccc93ce4a89f_349057b.jpg"))
                discos.add(Disco("Lovehatetragedy", "Papa Roach", "DreamWorks Records", 2002, "https://www.srcvinyl.com/media/catalog/product/cache/9/image/9df78eab33525d08d6e5fb8d27136e95/p/a/paparoa_lovehat_coverar_5000dpi300rgb1000166516.jpg"))
                discos.add(Disco("Getting Away With Murder", "Papa Roach", "Geffen Records", 2004, "https://images-na.ssl-images-amazon.com/images/I/712hHIq-nGL._SL1012_.jpg"))
                discos.add(Disco("The Paramour Sessions", "Papa Roach", "Geffen Records", 2006, "https://draw.acharts.net/cover/14585-55aa4367bfdc0-l.jpg"))
                discos.add(Disco("Metamorphosis", "Papa Roach", "Interscope Records", 2009, "https://images-na.ssl-images-amazon.com/images/I/81QOivJxcWL._SL1500_.jpg"))
                discos.add(Disco("The Connection", "Papa Roach", "Eleven Seven Music", 2012, "https://cdn.shopify.com/s/files/1/0965/5518/products/The_Connection_album_grande.jpg?v=1559760938"))
                discos.add(Disco("F.E.A.R.", "Papa Roach", "Eleven Seven Music", 2015, "https://www.rockshop.ro/images/product/14-paparoach-fear-cdjpg.jpg"))
                discos.add(Disco("Crooked Teeth", "Papa Roach", "Eleven Seven Music", 2017, "https://i1.wp.com/www.antiheromagazine.com/wp-content/uploads/2017/05/Crooked-Teeth.jpg?resize=638%2C470&ssl=1"))
            }
            else -> {
                discos.add(Disco("ERROR", "ERROR", "ERROR", 0, "https://blog.eduonix.com/wp-content/uploads/2015/02/404-Error.jpg"))
            }
        }

        adaptadorDiscos = AdaptadorDiscos(discos,applicationContext)
        binding.recyclerDiscos.adapter = adaptadorDiscos
        binding.recyclerDiscos.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)

    }
}