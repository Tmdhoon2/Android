package com.example.memo

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memo.databinding.ActivityMainBinding
import java.nio.channels.AsynchronousByteChannel

@SuppressLint("StaticFieldLeak")
class MainActivity : AppCompatActivity(), OnDeleteListener {

    private lateinit var binding:ActivityMainBinding

    lateinit var db:MemoDatabase
    var memoList = listOf<MemoEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = MemoDatabase.getInstatnce(this)!!      /// 데이터베이스 획득

        binding.btAdd.setOnClickListener{

            val memo = MemoEntity(null, binding.etMemo.text.toString())     // 메모 변수에 메모를 담는다
            insertMemo(memo)

            binding.etMemo.setText("")
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this)

        getAllMemos()

    }

    //1. Insert Data
    //2. Get Data
    //3. Delete Data
    //4. Set RecyclerView

    fun insertMemo(memo : MemoEntity){                              // Insert
        //1. MainThread vs WorkerThread(Background Thread)

        val insertTask = object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {         // onBackground
                db.memoDAO().insert(memo)                           // Add memo
            }

            override fun onPostExecute(result: Unit?) {             // execute
                super.onPostExecute(result)
                getAllMemos()                                       // Get Data
            }

        }

        insertTask.execute()
    }



    fun getAllMemos(){                                              //Get
        val getTask = (object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                memoList = db.memoDAO().getAll()                    // List
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecycelrView(memoList)
            }
        }).execute()

    }

    fun deleteMemo(memo: MemoEntity){
        val deleteTask = object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                db.memoDAO().delete(memo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }
        }

        deleteTask.execute()
    }

    fun setRecycelrView(memoList: List<MemoEntity>){
        binding.recyclerview.adapter = MyAdapter(this, memoList,this)
    }

    override fun onDeleteListener(memo: MemoEntity) {
        deleteMemo(memo)
    }
}