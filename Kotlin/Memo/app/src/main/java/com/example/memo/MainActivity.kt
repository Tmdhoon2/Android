package com.example.memo

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memo.databinding.ActivityMainBinding
import java.nio.channels.AsynchronousByteChannel

@SuppressLint("StaticFieldLeak")
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    lateinit var db : MemoDatabase
    var memoList = listOf<MemoEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MemoDatabase.getInstatnce(this)!!

        binding.btAdd.setOnClickListener{

            val memo = MemoEntity(null, binding.etMemo.text.toString())
            insertMemo(memo)

            binding.etMemo.setText("")
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

    }

    //1. Insert Data
    //2. Get Data
    //3. Delete Data
    //4. Set RecyclerView

    fun insertMemo(memo : MemoEntity){
        //1. MainThread vs WorkerThread(Background Thread)

        val insertTask = object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                db.memoDAO().insert(memo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }

        }

        insertTask.execute()
    }



    fun getAllMemos(){
        val getTask = (object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                memoList = db.memoDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecycelrView(memoList)
            }
        }).execute()

    }

    fun deleteMemo(){

    }

    fun setRecycelrView(memoList: List<MemoEntity>){
        binding.recyclerview.adapter = MyAdapter(this, memoList)
    }
}