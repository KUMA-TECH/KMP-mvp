//package store.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.MapColumn
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//import model.User
//
//@Dao
//interface UserDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(user: User)
//
//    @Query("SELECT * FROM User where name=:name")
//    fun getUserByName(name:String): Flow<User>
//
//    @Query("SELECT * FROM User WHERE id =:id")
//    suspend fun getUserById(id: Long): Map<@MapColumn(columnName = "id") Long, User>
//
//    @Query("SELECT COUNT(*) as count FROM User")
//    suspend fun count(): Int
//
//    @Query("SELECT * FROM User WHERE id in (:ids)")
//    suspend fun loadAll(ids: List<Long>): List<User>
//}
