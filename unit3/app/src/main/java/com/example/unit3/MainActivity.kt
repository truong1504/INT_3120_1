package com.example.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.unit3.ui.theme.Unit3Theme

// ----------- Problem 4: Basic Class -----------
open class Student(val name: String, val id: Int) {
    fun introduce(): String {
        return "Xin chào, tôi là $name, mã sinh viên $id."
    }
}

// ----------- Problem 5: Inheritance -----------
class HonorStudent(name: String, id: Int, val gpa: Double) : Student(name, id) {
    fun getScholarshipStatus(): String {
        return if (gpa >= 3.5) "Đủ điều kiện học bổng 🎓" else "Chưa đủ điều kiện học bổng."
    }
}

// ----------- Problem 6: Collections -----------
fun getStudentList(): MutableList<Student> {
    return mutableListOf(
        Student("An", 1001),
        Student("Bình", 1002),
        Student("Chi", 1003)
    )
}

// ----------- Problem 7: Kết hợp Classes + Collections -----------
fun listHonorStudents(students: List<HonorStudent>): String {
    return students.joinToString("\n") { "${it.name} (${it.id}) - GPA: ${it.gpa}" }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Unit3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PracticeScreen()
                }
            }
        }
    }
}

@Composable
fun PracticeScreen() {
    var output by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(onClick = {
            val s = Student("Trường", 22021205)
            output = s.introduce()
        }) {
            Text("Problem 4: Class")
        }

        Button(onClick = {
            val hs = HonorStudent("Lan", 22022222, 3.8)
            output = "${hs.introduce()}\n${hs.getScholarshipStatus()}"
        }) {
            Text("Problem 5: Inheritance")
        }

        Button(onClick = {
            val list = getStudentList()
            list.add(Student("Dũng", 22023443))
            output = list.joinToString("\n") { it.introduce() }
        }) {
            Text("Problem 6: Collections")
        }

        Button(onClick = {
            val honors = listOf(
                HonorStudent("Hà", 22044302, 3.9),
                HonorStudent("Minh", 22021204, 3.6)
            )
            output = listHonorStudents(honors)
        }) {
            Text("Problem 7: Combine")
        }

        Text(
            text = output,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}
