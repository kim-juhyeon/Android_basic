package ju.tutorials.roomdemo

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee-table")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true) // key값을 자동으로 배정
    val id: Int = 0,
    val name: String = "",
    @ColumnInfo(name = "email-id") //열 이름은 email-id
    val email: String ="",
)
