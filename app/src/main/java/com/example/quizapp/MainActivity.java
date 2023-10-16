package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public  static  ArrayList<ModelClass> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions=new ArrayList<>();



        questions.add(new ModelClass("भारत की राजधानी क्या है?", "मुंबई", "दिल्ली", "कोलकाता", "चेन्नई", "दिल्ली"));
        questions.add(new ModelClass("सूर्य की गर्मी किस तरह की ऊर्जा का स्रोत है?", "विद्युत ऊर्जा", "परमाणु ऊर्जा", "ऊर्जा काण्ड", "आवेशिक ऊर्जा", "परमाणु ऊर्जा"));
        questions.add(new ModelClass("किस गैस का प्रमुख घटक बालू होता है?", "ऑक्सीजन", "कार्बन डाइऑक्साइड", "नाइट्रोजन", "हाइड्रोजन", "नाइट्रोजन"));
        questions.add(new ModelClass("पृथ्वी का कौन-सा देश सबसे अधिक जनसंख्या वाला है?", "चीन", "रूस", "भारत", "अमेरिका", "भारत"));
        questions.add(new ModelClass("महात्मा गांधी का जन्म स्थल कहाँ पर हुआ था?", "पोरबंदर", "दिल्ली", "मुंबई", "कोलकाता", "पोरबंदर"));
        questions.add(new ModelClass("किस ब्रिटिश शासक ने भारत में सती प्रथा पर निषेध किया?", "रॉबर्ट क्लाइव", "वारेन हेस्टिंग्स", "विलियम बेन्टिंक", "लॉर्ड विलियम डेलहौजी", "वारेन हेस्टिंग्स"));
        questions.add(new ModelClass("सबसे बड़ा महासागर कौन सा है?", "अटलांटिक महासागर", "हिन्द महासागर", "आर्कटिक महासागर", "पैसिफिक महासागर", "पैसिफिक महासागर"));
        questions.add(new ModelClass("महाभारत किस युद्ध का एक प्रमुख घटक है?", "कुरुक्षेत्र युद्ध", "महाभारत युद्ध", "रामायण युद्ध", "पाणिपट युद्ध", "कुरुक्षेत्र युद्ध"));
        questions.add(new ModelClass("पानी की रूप में अधिक साकार रूप होने पर किसका तापमान कम होता है?", "तारकीय वायु", "तरल पेट्रोलियम गैस", "थोस पेट्रोलियम गैस", "तरल तारकीय वायु", "तरल पेट्रोलियम गैस"));
        questions.add(new ModelClass("सौरमंडल का सबसे छोटा ग्रह कौन सा है?", "बुध", "शुक्र", "मंगल", "पृथ्वी", "बुध"));
        questions.add(new ModelClass("भारत का सबसे ऊँचा और प्रधान वन्यजीव ध्वज कौन सा है?", "बाघ", "सिंह", "हाथी", "लेपर्ड", "हाथी"));
        questions.add(new ModelClass("भारतीय संविधान के प्रारूपक कौन थे?", "भगत सिंह", "बालगंगाधर तिलक", "बिमराव आंबेडकर", "मौलाना आजाद", "बालगंगाधर तिलक"));
        questions.add(new ModelClass("वर्ल्ड वाइड वेब किसने विकसित की थी?", "टिम बर्नर्स ली", "टिम ली", "आलन ट्यूरिंग", "अंड्रे बर्नर्स ली", "टिम बर्नर्स ली"));
        questions.add(new ModelClass("सूर्य के चारों ओर की पर्वाह न करने वाली ग्रह किसे कहा जाता है?", "कृष्ण पाक्षी", "काला ग्रह", "स्याही ग्रह", "काला द्विप", "कृष्ण पाक्षी"));
        questions.add(new ModelClass("विश्व में सबसे बड़ा द्वीप कौन-सा है?", "आफ्रीका", "आवर्ती", "एशिया", "ऑस्ट्रेलिया", "आवर्ती"));
        questions.add(new ModelClass("भारतीय रिज़र्व बैंक की स्थापना कब हुई थी?", "1942", "1947", "1950", "1955", "1950"));
        questions.add(new ModelClass("किस महापर्व के आयोजक लिहोल्बा में होते हैं?", "दिवाली", "दशहरा", "होली", "लोहड़ी", "दशहरा"));
        questions.add(new ModelClass("जब भीमरथी का नाम आता है, तो हम किसे याद करते हैं?", "विवेकानंद", "चाणक्य", "भगत सिंह", "डॉ. बी. आर. अंबेडकर", "डॉ. बी. आर. अंबेडकर"));
        questions.add(new ModelClass("किताब 'भगवद गीता' किस ग्रंथ का हिस्सा है?", "महाभारत", "रामायण", "महाभाष्य", "रिगवेद", "महाभारत"));

        // ... (previous code)

// Add more questions in Hindi to the ArrayList
        questions.add(new ModelClass("महाभारत का कितना पार्व है?", "14", "16", "18", "20", "18"));
        questions.add(new ModelClass("किस गैस को बारौंदों की गैस कहा जाता है?", "हेलियम", "नाइट्रोजन", "हाइड्रोजन", "ऑक्सीजन", "हेलियम"));
        questions.add(new ModelClass("विश्व में सबसे बड़ा उपमहाद्वीप कौन-सा है?", "आफ्रीका", "आवर्ती", "एशिया", "ऑस्ट्रेलिया", "एशिया"));
        questions.add(new ModelClass("सबसे बड़ा महाद्वीप कौन-सा है?", "आफ्रीका", "आवर्ती", "एशिया", "ऑस्ट्रेलिया", "आफ्रीका"));
        questions.add(new ModelClass("किताब 'अल्यूमिनियम की कहानी' किसकी है?", "मुंशी प्रेमचंद", "सत्यजित राय", "अनुपम सिन्हा", "डॉ. ए. पी. जे. अब्दुल कलाम", "अनुपम सिन्हा"));
        questions.add(new ModelClass("सबसे छोटा राष्ट्रीय मुद्रा कौन-सी है?", "यूरो", "डॉलर", "रूपी", "पैसो", "c) रूपी"));
        questions.add(new ModelClass("विश्व में सबसे ऊँचा पर्वत शिखर कौन-सा है?", "माउंट एवरेस्ट", "किलिमंजारो", "माउंट किनलाब", "विन्सन मासिफ", "माउंट एवरेस्ट"));
        questions.add(new ModelClass("कितने खिलाड़ी एक टेनिस डबल्स मैच में एक समय पर खेलते हैं?", "1", "2", "3", "4", "2"));
        questions.add(new ModelClass("भारतीय गणराज्य की संविधानिक भाषा क्या है?", "हिन्दी", "उर्दू", "अंग्रेजी", "संस्कृत", "हिन्दी"));
        // ... (previous code)

// Add 22 more questions in Hindi to the ArrayList
        questions.add(new ModelClass("किस ग्रह को 'सौरमंडल की नटी' भी कहा जाता है?", "बुध", "शुक्र", "पृथ्वी", "राहु", "शुक्र"));
        questions.add(new ModelClass("जब दिन के एक और रात के एक समय बराबर होता है, तो इसे क्या कहा जाता है?", "सूर्यास्त", "सूर्योदय", "समयावधि", "समय संवेदना", "सूर्यास्त"));
        questions.add(new ModelClass("संस्कृत में वन्दन किसे कहते हैं?", "पठन", "आराधना", "गायन", "उपदेशन", "आराधना"));
        questions.add(new ModelClass("भारत के पहले पुरुष अंतरिक्ष यात्री कौन थे?", "विक्रम सराभाई", "रवींद्रनाथ टैगोर", "कल्पना चावला", "सुनीता विलियम्स", "विक्रम सराभाई"));
        questions.add(new ModelClass("भारत के पहले महिला प्रधानमंत्री कौन थी?", "सोनिया गांधी", "इंदिरा गांधी", "सुषमा स्वराज", "प्रतिभा पाटिल", "इंदिरा गांधी"));
        questions.add(new ModelClass("सूरजमुखी का फूल किस दिशा की ओर मुख करता है?", "पूरब", "पश्चिम", "उत्तर", "दक्षिण", "उत्तर"));
        questions.add(new ModelClass("भारतीय मूवी इंडस्ट्री को 'बॉलीवुड' किसने पहली बार कहा?", "अमिताभ बच्चन", "रजनीकांत", "दिलीप कुमार", "ऋषि कपूर", "अमिताभ बच्चन"));
        questions.add(new ModelClass("किस गोलकर्ण को 'महाद्वीप' कहा जाता है?", "ऑस्ट्रेलिया", "आवर्ती", "एशिया", "आफ्रीका", "आवर्ती"));
        questions.add(new ModelClass("कौन-सा ग्लैंड शरीर के अंदर एक होता है?", "किडनी", "थायरॉयड", "लिवर", "लंग्ज", "थायरॉयड"));
        questions.add(new ModelClass("कितने खिलाड़ी एक बैडमिंटन डबल्स मैच में एक समय पर खेलते हैं?", "1", "2", "3", "4", "2"));
        questions.add(new ModelClass("किस खगोलशास्त्री के नाम पर ग्रह नामक 'कुमारी' प्राप्त हुआ है?", "सुभाष चंद्र बोस", "जवाहरलाल नेहरू", "हरीश चंद्र", "अर्विन्द चवान", "अर्विंद चवान"));
        questions.add(new ModelClass("भारत का सबसे बड़ा वन्यजीव संरक्षित क्षेत्र कहाँ है?", "गिर वन्यजीव अभयारण्य, गुजरात", "काजीरंगा वन्यजीव अभयारण्य, असम", "कान्हा वन्यजीव अभयारण्य, मध्य प्रदेश", "बंदिपुर वन्यजीव अभयारण्य, कर्नाटक", "गिर वन्यजीव अभयारण्य, गुजरात"));
        questions.add(new ModelClass("साधू किसे कहते हैं?", "संत", "साधक", "महात्मा", "वीर", "साधक"));
        questions.add(new ModelClass("किताब 'राग दरबार' किसकी है?", "प्रेमचंद", "अमृता प्रीतम", "सरोजिनी नायडू", "मुख्याध्यापिका अर्चना", "प्रेमचंद"));
        questions.add(new ModelClass("किस दिन 'हिन्दी दिवस' मनाया जाता है?", "14 नवंबर", "15 अगस्त", "26 जनवरी", "2 अक्टूबर", "26 जनवरी"));
        questions.add(new ModelClass("मानव शरीर का कितना प्रतिशत जल होता है?", "30%", "60%", "70%", "80%", "70%"));
        questions.add(new ModelClass("वनस्पति जीवन के कितने प्रकार के प्रमुख वृक्ष होते हैं?", "1", "2", "3", "4", "4"));
        questions.add(new ModelClass("किस प्लेनेट को 'भूद्वीप का ग्रह' कहा जाता है?", "मंगल", "बुध", "शुक्र", "गुरु", "मंगल"));
        questions.add(new ModelClass("ब्राह्मी समय किसके राजानुकूल हुआ था?", "अशोक", "कुषाण वंश", "हर्षवर्धन", "वर्धमान महावीर", "कुषाण वंश"));
        questions.add(new ModelClass("सूरज के चारों ओर की पर्वाह न करने वाली ग्रह किसे कहा जाता है?", "कृष्ण पाक्षी", "काला ग्रह", "स्याही ग्रह", "काला द्विप", "कृष्ण पाक्षी"));

// ... (rest of the code)


// ... (rest of the code)

        new Handler().postDelayed(() -> {
            Intent intent=new Intent(getApplicationContext(),dashboard.class);
    startActivity(intent);
        },5000);
    }
}