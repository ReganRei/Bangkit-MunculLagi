package com.rajatawar.myapplication.ui.main.add

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.rajatawar.myapplication.R
import com.rajatawar.myapplication.databinding.FragmentAddBinding
import com.rajatawar.myapplication.ui.main.MainViewModel

class AddFragment : Fragment() {

    private lateinit var filepath: Uri
    private lateinit var addViewModel: MainViewModel
    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnAdd.setOnClickListener {
            startFileChooser()
        }

        binding.button2.setOnClickListener {
            val img_url =
                "https://firebasestorage.googleapis.com/v0/b/raja-tawar.appspot.com/o/image%2F" + binding.edtJudul.text.toString() + "?alt=media&token=033128bd-60d5-434d-ab0f-6bcd7cbf3b5d"
            addViewModel.setAddItem1(
                img_url,
                binding.edtJudul.text.toString(),
                binding.edtNameRegister.text.toString()
            )
            addFragment(Add2Fragment())
        }
        return root
    }


    private fun uploadFile() {
        var pd = ProgressDialog(context)
        pd.setTitle("Uploading...")
        pd.show()

        var imageRef =
            FirebaseStorage.getInstance().reference.child("images/" + binding.edtJudul.text.toString() + ".jpg")
        imageRef.putFile(filepath)
            .addOnSuccessListener {
                pd.dismiss()
                Toast.makeText(context, "File Uploaded", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                pd.dismiss()
                Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()

            }
            .addOnProgressListener {
                var progress = (100.0 * it.bytesTransferred) / it.totalByteCount
                pd.setMessage("Uploaded ${progress.toInt()}%")
            }
    }

    private fun startFileChooser() {
        var i = Intent()
        i.setType("image/*")
        i.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(i, "Pilih Gambar"), 111)
        uploadFile()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == Activity.RESULT_OK && data != null) {
            filepath = data.data!!
            var bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver, filepath)
            binding.imageView4.setImageBitmap(bitmap)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun addFragment(frg: Fragment) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_main, frg)
            ?.commit()
    }
}