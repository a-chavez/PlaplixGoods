package cl.nodalnet.plaplixgoods.models.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATA_BASE_NAME="products_db"

@Database(entities = [ProductsItem::class],version = 1)

abstract class ProductsDB : RoomDatabase() {

   abstract fun getMasterDAO() : ProductsDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductsDB? = null

        fun getDataBase(context: Context): ProductsDB {
            //Para que no repita la instancia
            val tempInterface = INSTANCE
            if(tempInterface !=null) {
                return tempInterface
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                    ProductsDB::class.java,
                    DATA_BASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}