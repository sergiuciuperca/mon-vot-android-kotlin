package ro.code4.monitorizarevot.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import org.parceler.Parcel

@Entity(
    tableName = "question",
    foreignKeys = [ForeignKey(
        entity = Section::class,
        parentColumns = ["uniqueId"],
        childColumns = ["sectionId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
@Parcel(Parcel.Serialization.FIELD)
class Question {

    @PrimaryKey
    @Expose
    var id: Int = -1

    @Expose
    lateinit var text: String

    @Expose
    lateinit var code: String

    //1  single choice, 2 raspuns cu text, 3 multiple choice si raspuns liber 0 multiple choice
    @Expose
    var questionType: Int = 0

    @Expose
    @Ignore
//    @Relation(parentColumn = "id", entityColumn = "question_id")
    lateinit var optionsToQuestions: List<Answer>

    lateinit var sectionId: String

    @Ignore
    var savedLocally = false
    @Ignore
    var synced = false
}