package team.diamond.notesmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import team.diamond.notesmvvm.model.Note
import team.diamond.notesmvvm.utils.TYPE_ROOM


//констурктор ???????????
class MainViewModel (application: Application):AndroidViewModel(application) {

   val readTest:MutableLiveData<List<Note>> by lazy {
       MutableLiveData<List<Note>>()
   }

    val dbType: MutableLiveData<String> by lazy{
        MutableLiveData<String>(TYPE_ROOM)   //база данных по умолчанию ROOM
    }

    init {
        readTest.value =
            when(dbType.value){
                //  как рисовать стрелки ?
                TYPE_ROOM -- {
                    listOf<Note>(
                   Note(title = "Note 1", subtitle = "Subtitle for note 1"),
                   Note(title = "Note 2", subtitle = "Subtitle for note 2"),
                   Note(title = "Note 3", subtitle = "Subtitle for note 3"),
                   Note(title = "Note 4", subtitle = "Subtitle for note 4"),
                    )
                }
                TYPE_FIREBASE-- listOf()
                else -- listOf()
            }
    }

    fun iniDatabase(type: String){
        dbType.value = type
        Log.d("checkData","MainViewModel initDatabase with type: $type")
    }
}

class MainViewModelFactory (private val application: Application): ViewModelProvider.Factory{
    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
