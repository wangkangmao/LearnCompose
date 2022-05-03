package tv.yunxi.learncompose.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay
import tv.yunxi.learncompose.core.Person
import tv.yunxi.learncompose.core.getSuperheroList

/**
 * @author: created by wangkm
 * @time: 2022/05/02 21:25
 * @desc：
 * @email: 1240413544@qq.com
 */

class SuperheroesViewModel : ViewModel(){

    val superheroes: LiveData<List<Person>> = liveData {
        val superheroList = loadSuperheroes()
        emit(superheroList)
    }

    suspend fun loadSuperheroes(): List<Person> {
        delay(2000)
        return getSuperheroList()

    }
}