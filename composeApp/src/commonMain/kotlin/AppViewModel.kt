
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


/**
 * Application main viewmodel
 */
class AppViewModel : ViewModel() {

    fun initSDK() {
        viewModelScope.launch {
//            DataStoreFactory.create()
        }
    }
}