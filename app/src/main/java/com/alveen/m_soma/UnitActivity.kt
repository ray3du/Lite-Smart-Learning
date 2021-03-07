package com.alveen.m_soma

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class UnitActivity : AppCompatActivity() {
    private lateinit var topicRecyclerViewAdapter: TopicRecyclerViewAdapter
    private lateinit var database: FirebaseDatabase
    private lateinit var databaseRef: DatabaseReference
    private lateinit var mainTitle: TextView
    private lateinit var subTitle1: TextView
    private lateinit var subTitle2: TextView
    private lateinit var subTitle3: TextView
    private lateinit var subTitle4: TextView
    private lateinit var subTitle5: TextView
    private lateinit var subTitle6: TextView
    private lateinit var subTopic1: TextView
    private lateinit var subTopic2: TextView
    private lateinit var subTopic3: TextView
    private lateinit var subTopic4: TextView
    private lateinit var subTopic5: TextView
    private lateinit var subTopic6: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit)

        //Initialize realtime database
        database = FirebaseDatabase.getInstance()
        databaseRef = database.reference

        //val rcView = findViewById<RecyclerView>(R.id.rcView)

        mainTitle = findViewById(R.id.mainTitle)
        subTitle1 = findViewById(R.id.subTitle1)
        subTitle2 = findViewById(R.id.subTitle2)
        subTitle3 = findViewById(R.id.subTitle3)
        subTitle4 = findViewById(R.id.subTitle4)
        subTitle5 = findViewById(R.id.subTitle5)
        subTitle6 = findViewById(R.id.subTitle6)
        subTopic1 = findViewById(R.id.subTopic1)
        subTopic2 = findViewById(R.id.subTopic2)
        subTopic3 = findViewById(R.id.subTopic3)
        subTopic4 = findViewById(R.id.subTopic4)
        subTopic5 = findViewById(R.id.subTopic5)
        subTopic6 = findViewById(R.id.subTopic6)

        lateinit var subject: String

        val bundle: Bundle? = intent.extras

        if (bundle != null){
            subject = bundle.getString("subject", "")
        }

        if (subject == "biology"){
            handleBiology()
        }

        if (subject == "chemistry"){
            handleChemistry()
        }

        if (subject == "physics"){
            handlePhysics()
        }

        if (subject == "math"){
            handleMath()
        }

//        topicRecyclerViewAdapter = TopicRecyclerViewAdapter(mutableListOf())
//        rcView.adapter = topicRecyclerViewAdapter
//        rcView.layoutManager = LinearLayoutManager(this)

        val returnButton = findViewById<ImageView>(R.id.returnButton)



        returnButton.setOnClickListener {
            startActivity(Intent(this, MainViewActivity::class.java))
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainViewActivity::class.java))
        finish()
    }

    //handle biology
    private fun handleBiology(){
        // Read from the database
        // Read from the database
        databaseRef.child("Biology").addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
//                val value: Any? = dataSnapshot.value
//                println("Any data: ${value.toString()}")
//                if (value != null) {
//                    topicRecyclerViewAdapter.addData(TopicData(value.mainTitle, value.subTitle, value.mainText))
//                }
//                val value = dataSnapshot.getValue(TopicData::class.java)
//                println("Value: $value")
//                val data = TopicData(value?.mainTitle, value?.subTitle, value?.mainText)
//                println("Data $data")
//                topicRecyclerViewAdapter.addData(data)
                mainTitle.setText("Biology")
                subTitle1.setText("Introduction to Biology")
                subTitle2.setText("Branches of Biology")
                subTitle3.setText("Importance of Biology")
                subTitle4.setText("Characteristics of living things")
                subTitle5.setText("")
                subTitle6.setText("")
                subTopic1.setText(" Biology derived from Greek words - BIOS meaning LIFE and LOGOS meaning STUDY or KNOWLEDGE • Biology means 'life knowledge' • It is the study of living things/organisms")
                subTopic2.setText("• Botany - study of plants • Zoology - study of animals • Microbiology - study' of microscopic organisms • Morphology - study of external structure of organisms • Anatomy - study of internal structure of organisms • Physiology - study of the functioning or working of the cells or body • Biochemistry - study of the chemistry of materials in living organisms • Cytology - study of cells • Genetics - study of inheritance • Ecology- study of the relationship between organisms and their environment • Taxonomy - sorting out of organisms into groups • Histology - study of fine structure of tissues • Virology - study of viruses • Bacteriology - study of bacteria • Entomology - study of insects")
                subTopic3.setText("• One learns about the functioning of the human body • One understands the developmental changes that take place in the body • It contributes immensely to improved life • It enables one to enter careers such as:  Medicine,  Nutrition, Public Health,  Dentistry,  Agriculture  Environmental Studies  Teaching Characteristics")
                subTopic4.setText("Life defined through observations of activities carried out by living things;")
                subTopic5.setText("")
                subTopic6.setText("")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Toast.makeText(this@UnitActivity, "Failed to read database", Toast.LENGTH_SHORT).show()
            }
        })
    }
    //handle math
    @SuppressLint("SetTextI18n")
    private fun handleMath(){
        // Read from the database
        // Read from the database
//        databaseRef.child("Mathematics").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                //val value = dataSnapshot.getValue(TopicData::class.java)!!
//                //println(value.toString())
//                //recyclerViewAdapter = TopicRecyclerViewAdapter()
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Toast.makeText(this@UnitActivity, "Failed to read database", Toast.LENGTH_SHORT).show()
//            }
//        })
        mainTitle.setText("Mathematics")
        subTitle1.setText("Decimals")
        subTitle2.setText("Factors")
        subTitle3.setText("Integers")
        subTitle4.setText("Natural Numbers")
        subTitle5.setText("")
        subTitle6.setText("")
        subTopic1.setText("A decimal is a fraction whose denominator is a power of 10.  Express as decimal a) Express the following fraction as a decimal     ⅜    Express decimals as fractions a) Express the following decimal as a fraction     0.355    b) Express the following decimal as a fraction     3.24    Recurring Decimals An example of a recurring decimal is 0.83333 and can be represented as 0.83 a) Express the recurring decimal as fraction     0.632 (two digits recurring)    Decimal Places Decimals will be rounded off to a certain degree of accuracy Example: Round off   5.936   to (a) 1dp (b) 2dp and (c) 3dp  a) 6.0 b) 5.90 c) 5.940  Standard Form Writing numbers to be between 1 and 10 times a power of 10. Write the following numbers in standard form a)589 b) 0.00488  a) 5.89 x 102 b) 4.88 x 10-3 Standard Form Addition and Subtraction It is basic operations as integers 0.5832 + 1.859 = 2.4422")
        subTopic2.setText("When two numbers are multiplied to get a third number, the two numbers are factors. Consider: a x b = c ,    a and b are factors of c. c is referred to as the Multiple. A composite number is a number with more than two factors.  Factors of Composite numbers a) Write all the factors of 32 b) Express 32 as a product of two factors in 3 ways a) Factors of 32 are: 1, 2, 4, 8, 16, 32  b) 24    = 1 x 32    = 2 x 16    = 8 x 4 Prime Factors A prime number is a whole number greater than 1 that cannot be made by multiplying other whole numbers. E.g 2, 3, 5, 7, 11, 23. a) Write 120 as a product of it's prime factors in power form.  120    = 2 x 60    = 2 x 2 x 30    = 2 x 2 x 2 x 15    = 2 x 2 x 2 x 3 x 5    = 23 x 3 x 5 The above example can be presented using the factor tree method   b) Expand and find the value of 24 x 72 x 11  24 x 72 x 11    = 2 x 2 x 2 x 2 x 7 x 7 x 11    = 16 x 49 x 11    = 8624")
        subTopic3.setText("Number Line The illustration below shows numbers on a number line.   Operations on Integers Addition and Subtraction It should be noted that: a) + -  =  - b) - +  =  - c) - -  =  + d) + +  =  +  As a student, please try: ( For this questions, please draw a number line as the one shown above from -14 to +14 ) i) 4 + 8 ii) -4 + 8 iii) 4-(-8) iv) 4-8  (Check solution below) i) 4 + 8 This can be represented as: +4 + (+8). Using a number line, start at position 0. Move 4 steps to the right and further 8 steps to the right. What do you get? If your answer is +12, you are correct.  ii) -4 + 8 is the same as -4 + (+8) On the number line, start at position 0, move 4 to the left and then move 8 steps to the right. Your answer should be +4 or simply, 4  iii) 4 - (-8) is the same as +4 - (-8).  Remember, - - = +, hence the above problem is the same as 4 + 8 On the number line, start at position 0. Move 4 steps to the right and a further 8 steps to the right. Your answer should be +12 or simply, 12  iii) 4 - 8 is the same as +4 - (+8).  Remember, - + = -, hence the above problem is the same as 4 - 8 On the number line, start at position 0. Move 4 steps to the right and a then 8 steps to the left. Your answer should be -4  Multiplication and Division Rules of Multiplication and Division: Positive x positive = positive Positive x negative = negative negative x negative = positive negative x positive = negative Positive ÷ positive = positive Positive ÷ negative = negative negative ÷ negative = positive Order of Operations Remember BODMAS? This rule is followed in the order of operations. BODMAS stands for Bracket, Of, Division, Multiplication, Addition, Subtraction  Example: Solve 4 x 2(10-4) + 9 ÷ 3 - 10 Using BODMAS = 4 x 2(10 - 4) + 9 ÷ 3 - 10 = 4 x 2(6) + 9 ÷ 3 - 10 = 4 x 12 + 9 ÷ 3 - 10 = 4 x 12 + 3 - 10 = 48 + 3 - 10 = 51- 10 = 41 ")
        subTopic4.setText("Numbers are grouped in to Natural Numbers, Whole numbers, integers, rational numbers and irrational numbers.  Place Value Place value of digits in numbers helps in reading and performing arithmetic operations. Example 1: A place value chart is show below: 56, 894   Hence the amount in words will be, fifty six thousand, eight hundred and ninety four. Example 2: Use the 875, 351 to answer the questions that follow. a) What’s the place value of 8 ans: Hundred Thousands b) Write the number in words ans: Eight Hundred and seventy five thousand, three hundred and fifty one. Example 3: Use the 1,001, 001 to answer the questions that follow. a) Write the amount in words ans: One million, One thousand and One. Example 4: a) Write in figures: Seven hundred and sixty eight thousand, nine hundred and sixty eight ans: 768, 968 Rounding Off Numbers Requires writing a number to a given nearest place value Example: Consider: 589 371   Even and Odd Numbers Even Numbers – exactly divisible by 2 (has remainder 0) Examples: 2, 18, 30, 44, 5684 Odd Numbers – Not exactly divisible by 2 (has a remainder that is not 0) Examples: 5, 17, 29, 2589 Prime Numbers  These are numbers that have no other divisor except 1 and itself: Examples: 2, 3, 5, 7, 11, 19, 23, 29 Solving word problems Can you solve the problem below? Mbuthia sells bananas at his local market. Today, he bought 340 bananas at Ksh. 5 each. During transportation, 17 were badly damaged, 50 were partially damaged so he could sell them at half the price of a good banana. His selling price is Ksh. 20 each good banana. How much profit / loss did he make?")
        subTopic5.setText("")
        subTopic6.setText("")

    }

    //handle physics
    private fun handlePhysics(){
        // Read from the database
        // Read from the database
//        databaseRef.child("Physics").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                //val value = dataSnapshot.getValue(TopicData::class.java)!!
//                //println(value.toString())
//                //recyclerViewAdapter = TopicRecyclerViewAdapter()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Toast.makeText(this@UnitActivity, "Failed to read database", Toast.LENGTH_SHORT).show()
//            }
//        })
        mainTitle.text
        subTitle1.text
        subTitle2.text
        subTitle3.text
        subTitle4.text
        subTitle5.text
        subTitle6.text
        subTopic1.text
        subTopic2.text
        subTopic3.text
        subTopic4.text
        subTopic5.text
        subTopic6.text
    }

    //handle chemistry
    private fun handleChemistry(){
        // Read from the database
        // Read from the database
//        databaseRef.child("Chemistry").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                //val value = dataSnapshot.getValue(TopicData::class.java)!!
//                //println(value.toString())
//                //recyclerViewAdapter = TopicRecyclerViewAdapter()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Toast.makeText(this@UnitActivity, "Failed to read database", Toast.LENGTH_SHORT).show()
//            }
//        })
        mainTitle.text
        subTitle1.text
        subTitle2.text
        subTitle3.text
        subTitle4.text
        subTitle5.text
        subTitle6.text
        subTopic1.text
        subTopic2.text
        subTopic3.text
        subTopic4.text
        subTopic5.text
        subTopic6.text
    }
}