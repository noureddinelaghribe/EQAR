package com.noureddine.eqar.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentAdvancedSearchBinding
import android.text.Editable
import com.noureddine.eqar.utils.Constants.Companion.wilayaToBaladiasFr
import com.noureddine.eqar.utils.Constants.Companion.wilayasFr
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [advancedSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdvancedSearchFragment : Fragment() {
    private var _binding: FragmentAdvancedSearchBinding? = null
    private val binding get() = _binding!!

    // Search state
    private var selectedPropertyType: String? = null
    private var selectedOperationType: String? = null
    private var minPrice: String? = null
    private var maxPrice: String? = null
    private var selectedFeatures = mutableListOf<String>()
    private var selectedWilaya: String? = null
    private var selectedBaladia: String? = null
    private var selectedFurnishedStatus: String? = null
    private var checkInDate: String? = null
    private var checkOutDate: String? = null
    private var selectedStarRatings = mutableSetOf<Int>()

//    // Algerian states (Wilayas)
//    companion object {
//        val wilayas = listOf(
//            "01 - Adrar", "02 - Chlef", "03 - Laghouat", "04 - Oum El Bouaghi", "05 - Batna",
//            "06 - Béjaïa", "07 - Biskra", "08 - Béchar", "09 - Blida", "10 - Bouira",
//            "11 - Tamanrasset", "12 - Tébessa", "13 - Tlemcen", "14 - Tiaret", "15 - Tizi Ouzou",
//            "16 - Alger", "17 - Djelfa", "18 - Jijel", "19 - Sétif", "20 - Saïda",
//            "21 - Skikda", "22 - Sidi Bel Abbès", "23 - Annaba", "24 - Guelma", "25 - Constantine",
//            "26 - Médéa", "27 - Mostaganem", "28 - M'Sila", "29 - Mascara", "30 - Ouargla",
//            "31 - Oran", "32 - El Bayadh", "33 - Illizi", "34 - Bordj Bou Arréridj",
//            "35 - Boumerdès", "36 - El Tarf", "37 - Tindouf", "38 - Tissemsilt", "39 - El Oued",
//            "40 - Khenchela", "41 - Souk Ahras", "42 - Tipaza", "43 - Mila", "44 - Aïn Defla",
//            "45 - Naâma", "46 - Aïn Témouchent", "47 - Ghardaïa", "48 - Relizane",
//            "49 - Timimoun", "50 - Bordj Badji Mokhtar", "51 - Ouled Djellal", "52 - Béni Abbès",
//            "53 - In Salah", "54 - In Guezzam", "55 - Touggourt", "56 - Djanet",
//            "57 - El M'Ghair", "58 - El Meniaa"
//        )
//
//
//        // Complete Map of Wilayas to their municipalities (Baladias)
//        val wilayaToBaladias = mapOf(
//            "01 - Adrar" to listOf(
//                "Adrar", "Tamentit", "Reggane", "In Zghmir", "Tit", "Ksar Kaddour", "Tsabit",
//                "Timimoun", "Ouled Saïd", "Zaouiet Kounta", "Aoulef", "Timiaouine", "Tinerkouk",
//                "Deldoul", "Charouine", "Sebaa", "Ouled Ahmed Tammi", "Bouda", "Aougrout",
//                "Talmine", "Tamest", "Fenoughil", "Tamantit", "Reggan", "Sali", "Akabli",
//                "Metarfa", "Ouled Aissa"
//            ),
//
//            "02 - Chlef" to listOf(
//                "Chlef", "Ténès", "Benairia", "El Karimia", "Tadjena", "Taougrit", "Beni Haoua",
//                "Sobha", "Harchoun", "Ouled Farès", "Sidi Aakcha", "Boukadir", "Beni Rached",
//                "Talassa", "Herenfa", "Oued Goussine", "Dahra", "Ouled Abbes", "Sendjas",
//                "Zeboudja", "Oued Sly", "Abou El Hassen", "El Marsa", "Chettia", "Sidi Abderrahmane",
//                "Moussadek", "El Hadjadj", "Labiod Medjadja", "Oued Rhiou", "Ouled Ben Abdelkader",
//                "Bouzeghaia", "Breira", "Bentaiba", "Ain Merane", "Oum Drou"
//            ),
//
//            "03 - Laghouat" to listOf(
//                "Laghouat", "Ksar El Hirane", "Bennasser Benchohra", "Sidi Makhlouf", "Hassi Delaa",
//                "Hassi R'Mel", "Aïn Madhi", "Tadjmout", "Kheneg", "Gueltat Sidi Saad", "Aflou",
//                "El Assafia", "Oued Morra", "Oued M'Zi", "El Ghicha", "Hadj Mechri", "Sebgag",
//                "Taouiala", "Tadjrouna", "Krakda", "Sidi Bouzid", "El Houaita", "Brida", "Benacer Benchohra"
//            ),
//
//            "04 - Oum El Bouaghi" to listOf(
//                "Oum El Bouaghi", "Aïn Beida", "Aïn M'Lila", "Behir Chergui", "El Amiria", "Sigus",
//                "El Belala", "Aïn Babouche", "Berriche", "Ouled Hamla", "Dhalaa", "Aïn Kercha",
//                "Hanchir Toumghani", "El Djazia", "Aïn Diss", "Fkirina", "Souk Naamane", "Zorg",
//                "El Fedjoudj Boughrara Saoudi", "Ouled Zouaï", "Bir Chouhada", "Ksar Sbahi", "Oued Nini",
//                "Meskiana", "Aïn Fekroun", "Rahbat", "Aïn Zitoun", "Canrobert", "Ouled Gacem"
//            ),
//
//            "05 - Batna" to listOf(
//                "Batna", "Ghassira", "Maafa", "Merouana", "Seriana", "Menaa", "El Madher",
//                "Tazoult-Lambese", "N'Gaous", "Guigba", "Inoughissen", "Ouyoun El Assafir", "Djerma",
//                "Bitam", "Abdelkader", "Arris", "Kimmel", "Tilatou", "Aïn Djasser", "Ouled Sellam",
//                "Tigherghar", "Aïn Yagout", "Fesdis", "Sefiane", "Rahbat", "Tighanimine", "Lemsane",
//                "Ksar Bellezma", "Seggana", "Ichmoul", "Foum Toub", "Beni Foudhala El Hakania",
//                "Oued El Ma", "Talkhamt", "Bouzina", "Chemora", "Oued Chaaba", "Taxlent",
//                "Gosbat", "Ouled Aouf", "Boumagueur", "Barika", "Djezzar", "T'Kout", "Aïn Touta",
//                "Hidoussa", "Teniet El Abed", "Oued Taga", "Ouled Si Slimane", "Zanat El Beida",
//                "M'Doukal", "Ouled Fadel", "Timgad", "Ras El Aioun", "Chir", "Chemora", "Lazrou",
//                "Boumia", "Boulhilat", "Ghassira"
//            ),
//
//            "06 - Béjaïa" to listOf(
//                "Béjaïa", "Amizour", "Ferraoun", "Taourirt Ighil", "Chellata", "Tamokra", "Timezrit",
//                "Souk El Tenine", "M'Cisna", "Tinebdar", "Tichy", "Semaoun", "Kendira", "Tifra",
//                "Ighram", "Amalou", "Ighil Ali", "Fenaia Il Maten", "Toudja", "Darguina", "Sidi Ayad",
//                "Aokas", "Beni Djellil", "Adekar", "Akbou", "Seddouk", "Tazmalt", "Ait Rizine",
//                "Chemini", "Souk Oufella", "Taskriout", "Tibane", "Tala Hamza", "Barbacha", "Beni Ksila",
//                "Oued Ghir", "Ighil Nacer", "Tamridjet", "Taghzout", "Aït Smaïl", "Boukhelifa",
//                "Tizi N'Berber", "Beni Maouche", "Akfadou", "Leflaye", "Kherrata", "Draâ Kaid",
//                "Tamokra", "Bouhamza", "Beni Mellikeche", "Sidi Aïch", "El Kseur", "Melbou",
//                "Boudjellil", "Ait Mellouk", "Ait Rezine"
//            ),
//
//            "07 - Biskra" to listOf(
//                "Biskra", "Sidi Okba", "Chetma", "Foughala", "Branis", "Zeribet El Oued", "Sidi Khaled",
//                "M'Chouneche", "El Kantara", "Aïn Naga", "Zeribet El Oued", "El Feid", "Djemorah",
//                "Tolga", "Lioua", "Lichana", "Ouled Djellal", "Besbes", "El Ghrous", "Meziraa",
//                "Bouchagroune", "El Haouch", "Aïn Zaatout", "El Outaya", "Doucen", "Chaïba", "Khanguetr",
//                "Ouled Sassi", "Ras El Miaad", "Mechouneche", "Oumache", "Mlili", "Khoubana", "Ourlal"
//            ),
//
//            "08 - Béchar" to listOf(
//                "Béchar", "Kénadsa", "Lahmar", "Beni Ounif", "Tabelbala", "Igli", "Mogheul",
//                "Abadla", "Kerzaz", "Timoudi", "Ouled Khodeir", "Erg Ferradj", "Boukais",
//                "Mougheul", "Tamtert", "Beni Ikhlef", "Tagda", "El Ouata", "Béni Abbès",
//                "Ouled Khoudir", "Ksabi", "Timoudi", "Meridja", "Machraa Houari Boumediene"
//            ),
//
//            "09 - Blida" to listOf(
//                "Blida", "Chréa", "Boufarik", "Larbaa", "Oued Alleug", "Chiffa", "Hammam Melouane",
//                "Ben Khelil", "Soumaa", "Mouzaia", "El Affroun", "Chebli", "Bouinan", "Ouled Slama",
//                "Bougara", "Guerrouaou", "Aïn Romana", "Joubour", "Zeboudja", "Oued El Alleug",
//                "Souhane", "Ghrib", "Aïn El Hammam", "Ouled Yaïch", "Chiffa", "Oued Djer", "Meftah"
//            ),
//
//            "10 - Bouira" to listOf(
//                "Bouira", "Aïn Bessem", "Bir Ghbalou", "Bordj Okhriss", "El Hachimia", "Aomar",
//                "Chorfa", "Kadiria", "Djebahia", "Aïn El Hadjar", "Dirah", "Saharidj", "Souk El Khemis",
//                "Haizer", "Lakhdaria", "Maala", "Hoceinia", "Taghzout", "Ridane", "Bechloul",
//                "Boukram", "Aghbalou", "Zbarbar", "Aïn Turk", "Dechmia", "Aïn Laloui", "Aïn El Hadjar",
//                "M'Chedallah", "Sour El Ghozlane", "Aïn Bessem", "El Esnam", "Raouraoua", "Guerrouma",
//                "El Adjiba", "Taguedit", "Ath Mansour Taourirt", "Hadjout", "Ain Turk", "Ouamri",
//                "El Mokrani", "Aïn Laloui", "Aïn El Hadjar", "Aït Laziz", "Bouderbala", "El Hakimia"
//            ),
//
//            "11 - Tamanrasset" to listOf(
//                "Tamanrasset", "Abalessa", "In Ghar", "Tin Zaouatine", "Tazrouk", "Aïn Amguel",
//                "Aïn Salah", "Tazhout", "Idlès", "Tin Zaouatine", "Silet", "Aïn Guezzam", "Iferouene"
//            ),
//
//            "12 - Tébessa" to listOf(
//                "Tébessa", "Bir El Ater", "Cheria", "Stah Guentis", "El Aouinet", "Lahouidjbet",
//                "Safsaf El Ouesra", "Hammamet", "Négrine", "Bir Mokkadem", "El Kef", "Ferkane",
//                "Boukhadra", "Bekkaria", "Aïn Zerga", "El Meridj", "Boulhaf Dir", "Bedjene",
//                "El Morabet", "Gourig", "Bir Dheheb", "Ogla Melha", "Aïn Zerga", "Thlidjene",
//                "El Ogla", "El Kouif", "Morsott", "El Houidjbet"
//            ),
//
//            "13 - Tlemcen" to listOf(
//                "Tlemcen", "Chetouane", "Hennaya", "Maghnia", "Remchi", "Hammam Boughrara", "Ouled Mimoun",
//                "Aïn Tallout", "El Febala", "Aïn Ghoraba", "Ouled Riyah", "Bouhlou", "Souk Ahras",
//                "Sidi Abdelli", "Sebaa Chioukh", "Beni Mester", "Fellaoucen", "Azails", "Aïn Nehala",
//                "Beni Smiel", "Ghazaouet", "Souani", "Djebala", "El Gor", "Oued Lakhdar", "Ain Fezza",
//                "Ouled Mimoun", "Beni Ouarsous", "Souahlia", "Beni Boussaid", "Marsa Ben M'Hidi",
//                "Nedroma", "Sidi Medjahed", "Beni Snous", "Tianet", "Bab El Assa", "Dar Yaghmoracen",
//                "Honaine", "Tianet", "Sebdou", "Beni Bahdel", "Sidi Djillali", "Bensekrane",
//                "Aïn Kebira", "Sidi Senoussi", "Beni Semiel", "Terny Beni Hediel", "Zenata",
//                "Ouled Riyah", "Amieur", "Ain Fezza"
//            ),
//
//            "14 - Tiaret" to listOf(
//                "Tiaret", "Aïn Bouchekif", "Aïn Zarit", "Aïn Dheb", "Aïn Kermes", "Dahmouni",
//                "Rahouia", "Mahdia", "Sougueur", "Sidi Ali Mellal", "Aïn El Hadid", "Serghine",
//                "Bougara", "Faidja", "Rechaiga", "Nadorah", "Tagdemt", "Oued Lilli", "Mechraa Safa",
//                "Hamadia", "Chehaima", "Takhemaret", "Sidi Hosni", "Sebaine", "Tousnina", "Frenda",
//                "Aïn Kermes", "Ksar Chellala", "Rechaiga", "Zmalet El Emir Abdelkader", "Madna",
//                "Sebt", "Djebilet Rosfa", "Sidi Abdelghani", "Guertoufa", "Mellakou", "Sidi Bakhti",
//                "Chehaima", "Medrissa", "Djillali Ben Amar", "Aïn Bouchekif", "Faidja", "Naima",
//                "Medroussa", "Sidi Ali Mellal", "Mechraa Safa", "Chehaima"
//            ),
//
//            "15 - Tizi Ouzou" to listOf(
//                "Tizi Ouzou", "Aïn El Hammam", "Akbil", "Freha", "Souamaa", "Mechtarass", "Irdjen",
//                "Timizart", "Makouda", "Draa El Mizan", "Tizi Gheniff", "Bounouh", "Ait Chafaa",
//                "Frikat", "Beni Aissi", "Beni Zmenzer", "Iferhounene", "Azazga", "Illoula Oumalou",
//                "Yakouren", "Larbaâ Nath Irathen", "Tizi Rached", "Zekri", "Ouaguenoun", "Aïn Zaouia",
//                "M'Kira", "Ait Yahia", "Tirmitine", "Akerrou", "Yatafen", "Beni Ziki", "Draâ Ben Khedda",
//                "Ouadhias", "Azeffoun", "Tigzirt", "Ait Aggouacha", "Ouacif", "Mizrana", "Imsouhal",
//                "Tadmaït", "Aït Boumahdi", "Abi Youcef", "Beni Douala", "Illilten", "Bouzeguène",
//                "Ait Yahia Moussa", "Souk El Tenine", "Ait Khelili", "Sidi Namane", "Iboudraren",
//                "Aghribs", "Iflissen", "Boudjima", "Ait Oumalou", "Tizi N'Tleta", "Beni Ouglis",
//                "Ait Toudert", "Ait Bouaddou", "Assi Youcef", "Ait Aissa Mimoun", "Ait Boumahdi",
//                "Akerrou", "Imsouhal", "Ait Khellili", "Maatka", "Ait Yahia"
//            ),
//
//            "16 - Alger" to listOf(
//                "Alger Centre", "Bab El Oued", "Bologhine", "Casbah", "Oued Koriche", "Bir Mourad Raïs",
//                "Birkhadem", "Bourouba", "El Biar", "Hussein Dey", "Kouba", "Les Eucalyptus", "Rais Hamidou",
//                "Bab Ezzouar", "Baraki", "Dar El Beïda", "Douera", "Draria", "El Harrach", "El Magharia",
//                "Oued Smar", "Rouiba", "Sidi Moussa", "Aïn Taya", "Bordj El Bahri", "Bordj El Kiffan",
//                "El Marsa", "Hamma Bouziane", "Mohammadia", "Reghaia", "Saoula", "Staoueli", "Zeralda",
//                "Aïn Benian", "Cheraga", "Dely Ibrahim", "Hammamet", "Ouled Fayet", "Sidi Abdellah",
//                "Tessala El Merdja", "Mahelma", "Rahmania", "Souidania", "Khraicia", "Meftah", "Beni Mered",
//                "Bouinan", "Chebli", "Eucalyptus", "Hraoua", "Ouled Chebel", "Saoula", "Tessala El Merdja"
//            ),
//
//            "17 - Djelfa" to listOf(
//                "Djelfa", "Moudjbara", "El Guedid", "Hassi Bahbah", "Aïn El Ibel", "Aïn Oussera",
//                "Birine", "Bouira Lahdab", "Charef", "Deldoul", "Dar Chioukh", "El Khemis", "El Idrissia",
//                "Douis", "Faidh El Botma", "Guettara", "Hassi El Euch", "Messaad", "M'Liliha", "Sed Rahal",
//                "Selmana", "Sidi Baizid", "Sidi Ladjel", "Taadmit", "Zaafrane", "Zaccar", "Ain Maabed",
//                "Benhar", "Benyagoub", "Had Sahary", "Hassi Fedoul", "Oum Laadham", "Sidi Bouzid",
//                "Ain Chouhada", "El Jadida", "Guernini", "Hassi Delaa"
//            ),
//
//            "18 - Jijel" to listOf(
//                "Jijel", "Eraguene", "El Aouana", "Ziama Mansouria", "Taher", "Emir Abdelkader",
//                "Chekfa", "Chahna", "El Milia", "Sidi Marouf", "Settara", "El Ancer", "Jijel",
//                "Kaous", "Ghebala", "Bouraoui Belhadef", "Djimla", "Selma Benziada", "Boudriaa Beni Yadjis",
//                "Kheiri Oued Adjoul", "Texenna", "Djemaa Beni Habibi", "Bordj Taher", "Ouled Yahia Khedrouch",
//                "Ouled Rabah", "Ouadjana", "Sidi Abdelaziz", "Ziama Mansouria"
//            ),
//
//            "19 - Sétif" to listOf(
//                "Sétif", "Aïn El Kebira", "Aïn Sebt", "Ouled Sidi Ahmed", "Beïda Bordj", "El Eulma",
//                "Aïn Azel", "Mezloug", "Beni Aziz", "Ouled Tebben", "Rosfa", "Ouled Addouane",
//                "Belaa", "Aïn Roua", "Tixter", "Ras El Oued", "Reggane", "Tachouda", "Bousselam",
//                "El Ouricia", "Taya", "Aïn Legradj", "Ait Naoual Mezada", "Guidjel", "Aïn Oulmane",
//                "Serdj El Ghoul", "Harbil", "El Ouldja", "Tizi N'Bechar", "Salit", "Aïn Azal",
//                "Avoine", "Beni Chebana", "Ouled Si Ahmed", "Boutaleb", "Bazer Sakhra", "Hamam Soukhna",
//                "Bir Haddada", "Sidi Mesrane", "El Eulma", "Djemila", "Beni Fouda", "Tachouda",
//                "Amoucha", "Aïn Lahdjar", "Bougaa", "Darrem", "Tella", "Hammam Guergour", "Ait Tizi",
//                "Maouaklane", "Guenzet", "Talaifacene", "Beidha Bordj", "El Ouricia", "Hamma",
//                "Maaouia", "Aïn Arnat", "Aïn-Abessa", "Dehamcha", "Babor", "Oued El Bared",
//                "Ouled Sabor", "Ouled Sidi Ahmed", "Salah Bey", "Aïn Azal", "Bir El Arch", "Beni Aziz"
//            ),
//
//            "20 - Saïda" to listOf(
//                "Saïda", "Doui Thabet", "Ouled Brahim", "Moulay Larbi", "Youb", "Hounet",
//                "Sidi Amar", "Sidi Boubekeur", "El Hassasna", "Maamora", "Sidi Yacoub", "Tircine",
//                "Ain El Hadjar", "Ouled Khaled", "Sidi Ahmed", "Ain Soltane"
//            ),
//
//            "21 - Skikda" to listOf(
//                "Skikda", "El Hadaiek", "Azzaba", "Djendel Saadi Mohamed", "Ain Charchar", "Bekkouche Lakhdar",
//                "Benazouz", "Es Sebt", "Ouled Attia", "Oued Zhour", "Zerdezas", "Ouled Hebaba",
//                "Sidi Mezghiche", "Emjez Edchich", "Beni Oulbane", "Ain Bouziane", "Ramdane Djamel",
//                "Bin El Ouiden", "El Arrouch", "Salah Bouchaour", "Tamalous", "Ain Kechra", "Khenag Meyoun",
//                "Hamadi Krouma", "El Ghedir", "Bouchtata", "Oum Toub", "Beni Bachir", "Kerkera",
//                "Ouled Attia", "Filfila", "Cheraia", "Bidha", "Messaoudene", "Beni Zid", "Zeradezas",
//                "Collo", "Zitouna", "Ain Zouit", "Kanoua", "El Marsa", "Ben Azzouz"
//            ),
//
//            "22 - Sidi Bel Abbès" to listOf(
//                "Sidi Bel Abbès", "Tessala", "Sfisef", "Ain Thrid", "Merine", "Ras El Ma", "Sarno",
//                "Ain Tindamine", "Hassi Zahana", "Tilmouni", "Sidi Lahcene", "Ain Kada", "Moulay Slissen",
//                "Youb", "Tessala", "Telagh", "Sidi Hamadouche", "Mostefa Ben Brahim", "Sidi Khaled",
//                "Ain El Berd", "Tamayoute", "Benachiba Chelia", "Dhaya", "Zehana", "Ouriahet El Ghaaba",
//                "Sidi Brahim", "Mustafa Ben Brahiem", "Sidi Yacoub", "Lamtar", "Oued Sefioun",
//                "Ain Tindamine", "Ain Thrid", "Belarbi", "Ben Badis", "Boukhanafis", "Chetouane Belaila",
//                "El Hacaiba", "Hassi Dahou", "Hassi Zahana", "Makedra", "Marhoum", "Mcid", "Merine",
//                "Mezaourou", "Mostefa Ben Brahim", "Moulay Slissen", "Oued Sebaa", "Oued Sefioun",
//                "Ras El Ma", "Redjem Demouche", "Sehala Thaoura", "Sfisef", "Sidi Ali Benyoub",
//                "Sidi Ali Boussidi", "Sidi Brahim", "Sidi Chaib", "Sidi Dahou Dechara", "Sidi Hamadouche",
//                "Sidi Khaled", "Sidi Lahcene", "Sidi Yacoub", "Tabia", "Tamayoute", "Telagh",
//                "Tenira", "Tessala", "Tilmouni", "Zerouala"
//            ),
//
//            "23 - Annaba" to listOf(
//                "Annaba", "El Hadjar", "Ain Berda", "El Bouni", "Sidi Amar", "Chorfa", "Treat",
//                "Ain El Berda", "El Eulma", "Berrahal", "Chetaibi", "Oued El Aneb", "Seraidi",
//                "Cheurfa"
//            ),
//
//            "24 - Guelma" to listOf(
//                "Guelma", "Bouchegouf", "Nechmaya", "Roknia", "Ras El Agba", "Bordj Sabath",
//                "Belkheir", "Khezaras", "Hammam Debagh", "Oued Zenati", "Tamlouka", "Dahouara",
//                "Heliopolis", "Hammam N'Bail", "Ain Sandel", "Medjez Amar", "Boumahra Ahmed",
//                "Khezaras", "Guelaat Bou Sbaa", "Medjez Sfa", "Ain Makhlouf", "Houari Boumediene",
//                "Ain Larbi", "Fedj M'Zala", "Roknia", "Oued Fragha", "Beni Mezline", "Ben Djerrah",
//                "Bordj Sabath", "Ain Hessainia", "Sellaoua Announa", "Ain Ben Beida"
//            ),
//
//            "25 - Constantine" to listOf(
//                "Constantine", "El Khroub", "Hamma Bouziane", "Ibn Ziad", "Didouche Mourad", "Zighoud Youcef",
//                "Aïn Abid", "Aïn Smara", "Beni Hamiden", "Ouled Rahmoune", "Ibn Badis", "Messaoud Boudjriou",
//                "Aïn El Bey", "Aïn Kerma", "Ouled Rahmoune", "El Meridj", "Beni Hamiden", "Ain Smara"
//            ),
//
//            "26 - Médéa" to listOf(
//                "Médéa", "Ouzera", "Aïn Boucif", "Ouamri", "Si Mahdjoub", "Derrag", "El Azizia",
//                "Damiat", "Boughezoul", "Chellalet El Adhaoura", "Bir Ben Laabed", "El Ouinet",
//                "Mihoub", "Maghraoua", "Baata", "Tamesguida", "Khams Djouamaa", "Souagui",
//                "Beni Slimane", "Djelida", "Des Deux Bassins", "Boghar", "Tafraout", "Cheniguel",
//                "Ain Ouksir", "Aziz", "Oued Harbil", "Tablat", "Guelb El Kebir", "Bouskene",
//                "El Hamdania", "Benchicao", "Zoubiria", "Fid Hammad", "Saneg", "Sidi Demed",
//                "Sidi Naamane", "Ksar El Boukhari", "El Guelbelkebir", "Ain Ouksir", "Bouchrahil",
//                "Hannacha", "Zemmoura", "Oum El Djellil", "Ouled Antar", "Sidi Zahar", "Tizi Mahdi",
//                "Chahbouna", "Tlatet Eddouair", "Mezghana", "Chelalet Eladhaoura", "Draa Essamar",
//                "Rebaia", "Sedraia", "Sidi Ziane", "Ain Boucif", "Ouled Brahim", "Ouled Hellal",
//                "Berrouaghia", "Seghouane", "Sidi Naamane", "Ben Chicao", "El Azizia", "Ouled Deide",
//                "Ain Bourek", "Medjebar", "Sidi Rabie", "El Omaria", "Ouled Maimon"
//            ),
//
//            "27 - Mostaganem" to listOf(
//                "Mostaganem", "Sayada", "Fornaka", "Stidia", "Ain Nouissy", "Hassi Mameche", "Ain Tadles",
//                "Sour", "Ouled Maalah", "Sidi Ali", "Abdelmalek Ramdane", "Ain Boudinar", "Tazgait",
//                "Sidi Belattar", "El Matmar", "Mansourah", "Souaflia", "Bouguirat", "Sirat", "Ain Sidi Cherif",
//                "Mesra", "Mazagran", "Benabdelmalek Ramdane", "Kheir Eddine", "Sidi Lakhdar", "Touahria",
//                "Nekmaria", "Safi", "Khadra", "Ouled Boughalem", "Hadjadj", "Oued El Kheir", "Stidia",
//                "Achaacha"
//            ),
//
//            "28 - M'Sila" to listOf(
//                "M'Sila", "Magra", "Hammam Dalaa", "Ouled Derraj", "Tarmount", "Maarif", "Ouanougha",
//                "Sidi Aissa", "Berhoum", "Bou Saada", "Ouled Sidi Brahim", "Sidi Ameur", "Tamsa",
//                "Ben Srour", "Mohamed Boudiaf", "Ouled Addi Guebala", "Belaiba", "Sidi Hadjeres",
//                "Djebel Messaad", "Hammam Dalaa", "Ain El Hadjel", "Zarzour", "Khoubana", "Mchouneche",
//                "Benzouh", "Ouled Slimane", "El Houamed", "Ain El Melh", "Ouled Mansour", "Maadid",
//                "Souamaa", "Ain Fares", "Chellal", "Khettouti Sed Eldjir", "Slim", "Dehahna",
//                "Bouti Sayeh", "Bir Foda", "Sidi Aissa", "Medjedel", "Ouled Madhi", "Benaissa",
//                "Ouled Sidi Brahim", "Ain Khadra", "Menaa", "Hammam Dalaa", "Ouled Derradj"
//            ),
//
//            "29 - Mascara" to listOf(
//                "Mascara", "Bouhanifia", "Tighennif", "Oued El Abtal", "Ain Fares", "Sig", "Mamounia",
//                "Aouf", "Alaimia", "El Bordj", "Ras Ain Amirouche", "Khalouia", "El Menaouer",
//                "Sidi Kada", "Zelamta", "Oued Taria", "Sidi Abdelmoumene", "Ferraguig", "El Gaada",
//                "Chorfa", "Hachem", "Mohammadia", "Sidi Abdeldjebar", "Nesmoth", "Ain Fekan",
//                "Guerdjoum", "El Hachem", "Sehailia", "Frocha", "Matemore", "Makda", "Oggaz",
//                "Benian", "Sedjerara", "Mokhda", "Ghriss", "Maoussa", "Bou Henni", "El Keurt",
//                "Oued El Abtal", "Ras Ain Amirouche", "Sidi Abdelmoumene", "Tizi"
//            ),
//
//            "30 - Ouargla" to listOf(
//                "Ouargla", "N'Goussa", "Hassi Messaoud", "Rouissat", "Ain Beida", "Sidi Khouiled",
//                "Hassi Ben Abdallah", "Temacine", "Touggourt", "Nezla", "Zaouia El Abidia", "El Alia",
//                "Blidet Amor", "Taibet", "Benaceur", "El Borma", "Hassi El Gara", "Sidi Slimane",
//                "El Hadjira", "Megarine", "Djamaa", "Umm Es Thiour", "Still", "M'Naguer", "Hassi Messaoud"
//            ),
//
//            "31 - Oran" to listOf(
//                "Oran", "Bir El Djir", "Hassi Bounif", "Es Senia", "Arzew", "Bethioua", "Mers El Kébir",
//                "Aïn El Turk", "Bousfer", "El Ançor", "Oued Tlelat", "Tafraoui", "Sidi Chami", "Messerghine",
//                "Boutlelis", "Aïn Kerma", "Ben Freha", "Hassi Ben Okba", "Hassi Mefsoukh", "Sidi Ben Yebka",
//                "El Braya", "Gdyel", "Ain El Bia", "Marsat El Hadjadj", "Ain Kerma", "Boufatis", "Hassi Bounif"
//            ),
//
//            "32 - El Bayadh" to listOf(
//                "El Bayadh", "Rogassa", "Stitten", "Brezina", "Ghassoul", "Bougtob", "El Kheither",
//                "Kef El Ahmar", "Boualem", "Ain El Orak", "Arbaouat", "Brida", "Cheguig", "El Mehara",
//                "Tousmouline", "Sidi Amar", "Sidi Slimane", "Sidi Taifour", "Kraakda", "Chellala",
//                "Labiodh Sidi Saikh", "Ain Ouarka"
//            ),
//
//            "33 - Illizi" to listOf(
//                "Illizi", "Djanet", "Bordj Omar Driss", "Debdeb", "In Amenas"
//            ),
//
//            "34 - Bordj Bou Arréridj" to listOf(
//                "Bordj Bou Arréridj", "Ras El Oued", "Bordj Zemouri", "Mansourah", "Medjana", "Teniet En Nasr",
//                "Jaafra", "El Hamadia", "Ain Taghrout", "Bordj Ghedir", "Sidi Embarek", "Ouled Brahem",
//                "Ouled Dahmane", "Haraza", "El Mhir", "Ben Daoud", "El Achir", "Ain Tesra", "Bir Kasdali",
//                "El Euch", "Ghilasa", "Rabta", "Belimour", "Djaafra", "El Ksour", "Ouled Sidi Brahim",
//                "Tixter", "Colla", "Taglait", "Ksour", "Ouled Dahmane", "Tassamert", "Ouled Sidi Brahim"
//            ),
//
//            "35 - Boumerdès" to listOf(
//                "Boumerdès", "Naciria", "Djinet", "Isser", "Zemmouri", "Si Mustapha", "Tidjelabine",
//                "Chabet El Ameur", "Thenia", "Timezrit", "Corso", "Ouled Moussa", "Larbatache",
//                "Boudouaou", "Afir", "Bordj Menaiel", "Baghlia", "Sidi Daoud", "Conséquent", "Khemisti",
//                "Hammedi", "Ouled Aissa", "Ben Choud", "Dellys", "Ammal", "Beni Amrane", "Souk El Had",
//                "Bouzegza Keddara", "Taourga", "Ouled Heddadj", "Leghata", "Beni Amrane", "El Kharrouba",
//                "Issers"
//            ),
//
//            "36 - El Tarf" to listOf(
//                "El Tarf", "Bouhadjar", "Ben M'Hidi", "Boutheldja", "El Aioun", "Souarekh", "Berrihane",
//                "Lac des Oiseaux", "Cheffia", "Drean", "Chihani", "Hammam Beni Salah", "Raml Souk",
//                "Ain El Assel", "El Chatt", "Zitouna", "Oued Zitoun", "Besbes", "Asfour", "Echatt"
//            ),
//
//            "37 - Tindouf" to listOf(
//                "Tindouf", "Oum El Assel"
//            ),
//
//            "38 - Tissemsilt" to listOf(
//                "Tissemsilt", "Bordj Bou Naama", "Theniet El Had", "Lazharia", "Beni Chaib", "Lardjem",
//                "Melaab", "Sidi Lantri", "Bordj El Emir Abdelkader", "Layoune", "Khemisti", "Ouled Bessem",
//                "Ammari", "Youssoufia", "Sidi Boutouchent", "Larbaa", "Maasem", "Sidi Abed", "Tamalaht",
//                "Boucaid", "Beni Lahcene", "Ouled Bessem", "Sidi Slimane"
//            ),
//
//            "39 - El Oued" to listOf(
//                "El Oued", "Robbah", "Oued El Alenda", "Bayadha", "Nakhla", "Guemar", "Kouinine",
//                "Reguiba", "Hamraia", "Taghzout", "Debila", "Hassani Abdelkrim", "Hassi Khalifa",
//                "Trifaoui", "Magrane", "Djamaa", "Oum Touyour", "Sidi Aoun", "Tamerlaght", "Tendla",
//                "El Ogla", "Mih Ouansa", "Ben Guecha", "Ourmes", "Still", "Taleb Larbi"
//            ),
//
//            "40 - Khenchela" to listOf(
//                "Khenchela", "Mtoussa", "Kais", "Baghai", "El Hamma", "Ain Touila", "Taouzianat",
//                "Bouhmama", "El Oueldja", "Remila", "Cherchar", "Djellal", "Babar", "Tamsa", "Ensigha",
//                "Ouled Rechache", "El Mahmal", "Msara", "Yabous", "Khirane", "Chelia"
//            ),
//
//            "41 - Souk Ahras" to listOf(
//                "Souk Ahras", "Sedrata", "Hanancha", "Mechroha", "Ouled Driss", "Tiffech", "Zaarouria",
//                "Taoura", "Drea", "Heddada", "Ain Soltane", "Ain Zana", "Ouled Moumen", "Bir Bouhouche",
//                "Safel El Ouiden", "Ragoubet Naam", "Khemissa", "Oum El Adhaim", "Ain Kercha", "Terraguelt",
//                "Lahdeb", "Merahna", "Sidi Fredj", "M'Daourouch", "Ouillen"
//            ),
//
//            "42 - Tipaza" to listOf(
//                "Tipaza", "Menaceur", "Larhat", "Douaouda", "Bourkika", "Khemisti", "Agha Boulkrim",
//                "Hetatba", "Sidi Amar", "Chaiba", "Ain Tagourait", "Cherchell", "Damous", "Meurad",
//                "Fouka", "Bou Ismail", "Ahmer El Ain", "Bouharoun", "Sidi Ghiles", "Messelmoun",
//                "Sidi Rached", "Kolea", "Attatba", "Sidi Semiane", "Bou Haroun", "Hadjeret Ennous",
//                "Gouraya"
//            ),
//
//            "43 - Mila" to listOf(
//                "Mila", "Ferdjioua", "Chelghoum Laid", "Oued Athmania", "Aïn Mellouk", "Telerghma",
//                "Oued Seguen", "Tadjenanet", "Benyahia Abderrahmane", "Ain Tine", "El Mechira",
//                "Oued Endja", "Ain Beida Harriche", "Minar Zarza", "Amira Arres", "Tessala Lamtai",
//                "Grarem Gouga", "Hamala", "Rouached", "Ahmed Rachedi", "Chigara", "Nechmaya",
//                "Derradji Bousselah", "Sidi Merouane", "Tiberguent", "Bouhatem", "Zeghaia",
//                "Elayadi Barbes", "Sidi Khelifa", "Yahia Beniguecha", "Ouled Khalouf", "Terrai Bainen"
//            ),
//
//            "44 - Aïn Defla" to listOf(
//                "Aïn Defla", "Khemis Miliana", "Rouina", "Arib", "Djelida", "El Amra", "Barbouche",
//                "Djendel", "Oued Chorfa", "Ain Bouyahia", "El Karimia", "Oued Fodda", "Miliana", "Ben Allal",
//                "Bir Ould Khelifa", "Bourached", "Khemis Miliana", "Hammam Righa", "Arib", "Ain Torki",
//                "Sidi Lakhdar", "Hoceinia", "Tacheta Zougagha", "Ain Benian", "Zeddine", "Oued Djemaa",
//                "Bathia", "Tiberkanine", "Belaas", "Ben Allal", "Ain Sultan", "Bourached", "El Maine",
//                "Mekhatria", "Ain Bouyahia", "Zeddine"
//            ),
//
//            "45 - Naâma" to listOf(
//                "Naâma", "Mécheria", "Aïn Sefra", "Tiout", "Sfissifa", "Moghrar", "Assela", "Djeniane Bourzeg",
//                "Aïn Ben Khelil", "Makman Ben Amer", "Kasdir", "El Biod"
//            ),
//
//            "46 - Aïn Témouchent" to listOf(
//                "Aïn Témouchent", "Hammam Bouhadjar", "Aïn Tolba", "Terga", "Aïn Kihal", "Sidi Ben Adda",
//                "Aoubellil", "Aghlal", "Beni Saf", "Sidi Safi", "Oulhaça El Gheraba", "Tamzoura", "Chentouf",
//                "Sidi Boumediene", "Oued Berkeche", "Aïn El Arbaa", "El Malah", "Chaabat El Leham",
//                "Sidi Ouriache", "M'Sirda Fouaga", "Hassi El Ghella", "Hassi Dahdi", "El Amria", "Emir Abdelkader",
//                "Oued Sabah", "Ouled Boudjemaa", "Ain Larbaa"
//            ),
//
//            "47 - Ghardaïa" to listOf(
//                "Ghardaïa", "El Menia", "Dhayet Ben Dhahoua", "Berriane", "Metlili", "El Atteuf", "Ouled Chaneb",
//                "Mansourah", "Hassi Fehal", "Hassi El Gara", "Zelfana", "Sebseb", "Bounoura"
//            ),
//
//            "48 - Relizane" to listOf(
//                "Relizane", "Oued Rhiou", "Belaabes", "Sidi Saada", "Ouled Aissa", "Sidi Lazreg",
//                "El Hamadna", "Mazouna", "Kalaa", "Ain Rahma", "Yellel", "Oued Essalem", "Ouarizane",
//                "Lahlef", "Beni Dergoun", "Sidi M'Hamed Benaouda", "Hassi Mameche", "Mediouna",
//                "Sidi Khettab", "Ammi Moussa", "Zemmoura", "Beni Zenthis", "Souk El Haad", "Djidiouia",
//                "El Guettar", "Hamri", "El Matmar", "Ramka", "Mendes", "Sidi M'Hamed Benali", "Ain Tarek",
//                "Oued El Djemaa", "Merdja Sidi Abed", "Ouled Sidi Mihoub", "Beni Dergoun", "El Ouldja",
//                "Sidi Saada", "Dar Ben Abdelah", "Bendaoud"
//            ),
//
//            "49 - Timimoun" to listOf(
//                "Timimoun", "Ouled Aissa", "Ouled Said", "Tinerkouk", "Deldoul", "Metarfa", "Talmine"
//            ),
//
//            "50 - Bordj Badji Mokhtar" to listOf(
//                "Bordj Badji Mokhtar", "Timiaouine", "Tin Zaouatine"
//            ),
//
//            "51 - Ouled Djellal" to listOf(
//                "Ouled Djellal", "Sidi Khaled", "Besbes", "Chaiba", "Doucen", "Ras El Miaad"
//            ),
//
//            "52 - Béni Abbès" to listOf(
//                "Béni Abbès", "Tabelbala", "Igli", "Ouled Khoudir", "Tamtert", "Timoudi", "El Ouata",
//                "Kerzaz", "Ksabi"
//            ),
//
//            "53 - In Salah" to listOf(
//                "In Salah", "Foggaret Ezzaouia", "In Ghar"
//            ),
//
//            "54 - In Guezzam" to listOf(
//                "In Guezzam", "Tin Zaouatine"
//            ),
//
//            "55 - Touggourt" to listOf(
//                "Touggourt", "Tebesbest", "Nezla", "El Alia", "Temacine", "Blidet Amor", "Taibet",
//                "Megarine", "M'Naguer", "Sidi Slimane", "Zaouia El Abidia"
//            ),
//
//            "56 - Djanet" to listOf(
//                "Djanet", "Bordj El Houasse"
//            ),
//
//            "57 - El M'Ghair" to listOf(
//                "El M'Ghair", "Djamaa", "Oum Touyour", "Sidi Aoun", "Ourmes", "Still"
//            ),
//
//            "58 - El Meniaa" to listOf(
//                "El Meniaa", "Hassi Gara", "Hassi Fehal"
//            )
//        )
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAdvancedSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinners()
        setupPropertyTypeSelection()
        setupOperationTypeSelection()
        setupFeaturesSelection()
        setupFurnishedStatusSelection()
        setupPriceRangeSlider()
        //setupHotelPriceRangeSlider()
        //setupDatePickers()
        //setupStarRatingSelection()
        setupButtons()
    }

    private fun setupSpinners() {
        // Setup Wilaya spinner
        val wilayaAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, wilayasFr)
        (binding.spinnerWilaya as? AutoCompleteTextView)?.apply {
            setAdapter(wilayaAdapter)
            setOnItemClickListener { _, _, position, _ ->
                selectedWilaya = wilayasFr[position]
                updateBaladiaSpinner(selectedWilaya)
            }
        }

        // Setup Baladia spinner
        (binding.spinnerBaladia as? AutoCompleteTextView)?.apply {
            setOnItemClickListener { _, _, position, _ ->
                val baladias = wilayaToBaladiasFr[selectedWilaya] ?: emptyList()
                if (position < baladias.size) {
                    selectedBaladia = baladias[position]
                }
            }
        }
    }

    private fun updateBaladiaSpinner(selectedWilaya: String?) {
        val baladias = wilayaToBaladiasFr[selectedWilaya] ?: emptyList()
        val baladiaAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, baladias)
        (binding.spinnerBaladia as? AutoCompleteTextView)?.apply {
            setAdapter(baladiaAdapter)
            setText("") // Clear previous selection
        }
    }

    private fun setupPropertyTypeSelection() {

        binding.toggleRealestate.isChecked = true
        binding.toggleHotels.isChecked = false
        //binding.llHotels.visibility = View.GONE
        binding.llRealestate.visibility = View.VISIBLE

        // Real Estate vs Hotels toggle
        binding.toggleRealestate.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Real Estate", Toast.LENGTH_SHORT).show()
                binding.toggleHotels.isChecked = false
                //binding.llHotels.visibility = View.GONE
                binding.llRealestate.visibility = View.VISIBLE
            }
        }

        binding.toggleHotels.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Hotels", Toast.LENGTH_SHORT).show()
                binding.toggleRealestate.isChecked = false
                //binding.llHotels.visibility = View.VISIBLE
                binding.llRealestate.visibility = View.GONE
            }
        }

        // Property type toggles
        val propertyTypeToggles = mapOf(
            binding.toggleApartment to "شقة",
            binding.toggleHouse to "منزل",
            binding.toggleCommercial to "محل تجاري",
            binding.toggleVilla to "فيلا",
            binding.togglePartyHall to "قاعة حفلات"
        )

        propertyTypeToggles.forEach { (toggle, type) ->
            toggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedPropertyType = type
                    // Uncheck other toggles
                    propertyTypeToggles.forEach { (otherToggle, _) ->
                        if (otherToggle != toggle) {
                            otherToggle.isChecked = false
                        }
                    }
                } else if (selectedPropertyType == type) {
                    selectedPropertyType = null
                }
            }
        }
    }

    private fun setupOperationTypeSelection() {
        val operationTypeToggles = mapOf(
            binding.toggleRent to "كراء",
            binding.toggleSale to "بيع",
            binding.toggleExchange to "تبادل"
        )

        operationTypeToggles.forEach { (toggle, type) ->
            toggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Uncheck all other toggles in the group
                    operationTypeToggles.keys.forEach { otherToggle ->
                        if (otherToggle != toggle) {
                            otherToggle.isChecked = false
                        }
                    }
                    selectedOperationType = type
                } else {
                    selectedOperationType = null
                }
            }
        }
    }

    private fun setupFeaturesSelection() {
        val featureToggles = mapOf(
            binding.toggleParking to "موقف سيارة",
            binding.toggleGarden to "حديقة",
            binding.togglePool to "بركة سباحة",
            binding.toggleSecurity to "حراسة"
        )

        featureToggles.forEach { (toggle, feature) ->
            toggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    selectedFeatures.add(feature)
                } else {
                    selectedFeatures.remove(feature)
                }
            }
        }
    }

    private fun setupFurnishedStatusSelection() {
        val furnishedToggles = mapOf(
            binding.toggleFurnishedYes to "نعم",
            binding.toggleFurnishedNo to "لا",
            binding.toggleFurnishedDoesntMatter to "لايهم"
        )

        furnishedToggles.forEach { (toggle, status) ->
            toggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Uncheck all other toggles in the group
                    furnishedToggles.keys.forEach { otherToggle ->
                        if (otherToggle != toggle) {
                            otherToggle.isChecked = false
                        }
                    }
                    selectedFurnishedStatus = status
                } else {
                    selectedFurnishedStatus = null
                }
            }
        }
    }

    private fun setupPriceRangeSlider() {
        binding.priceRangeSlider.addOnChangeListener { slider, _, _ ->
            val values = slider.values
            val minPrice = values[0].toInt()
            val maxPrice = values[1].toInt()

            // Update the text fields
            binding.etMinPrice.setText(minPrice.toString())
            binding.etMaxPrice.setText(maxPrice.toString())
        }

        // Update slider when text fields change
        binding.etMinPrice.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val minPrice = s.toString().toIntOrNull() ?: 0
                val maxPrice = binding.etMaxPrice.text.toString().toIntOrNull() ?: 100000
                if (minPrice <= maxPrice) {
                    binding.priceRangeSlider.setValues(minPrice.toFloat(), maxPrice.toFloat())
                }
            }
        })

        binding.etMaxPrice.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val maxPrice = s.toString().toIntOrNull() ?: 100000
                val minPrice = binding.etMinPrice.text.toString().toIntOrNull() ?: 0
                if (minPrice <= maxPrice) {
                    binding.priceRangeSlider.setValues(minPrice.toFloat(), maxPrice.toFloat())
                }
            }
        })
    }

//    private fun setupHotelPriceRangeSlider() {
//
//        binding.priceRangeSliderHotel.addOnChangeListener { slider, _, _ ->
//            val values = slider.values
//            val minPrice = values[0].toInt()
//            val maxPrice = values[1].toInt()
//
//            // Update the text fields
//            binding.etMinPriceHotel.setText(minPrice.toString())
//            binding.etMaxPriceHotel.setText(maxPrice.toString())
//        }
//
//        // Update slider when text fields change
//        binding.etMinPrice.addTextChangedListener(object : android.text.TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//            override fun afterTextChanged(s: Editable?) {
//                val minPrice = s.toString().toIntOrNull() ?: 0
//                val maxPrice = binding.etMaxPriceHotel.text.toString().toIntOrNull() ?: 100000
//                if (minPrice <= maxPrice) {
//                    binding.priceRangeSliderHotel.setValues(minPrice.toFloat(), maxPrice.toFloat())
//                }
//            }
//        })
//
//        binding.etMaxPrice.addTextChangedListener(object : android.text.TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//            override fun afterTextChanged(s: Editable?) {
//                val maxPrice = s.toString().toIntOrNull() ?: 100000
//                val minPrice = binding.etMinPriceHotel.text.toString().toIntOrNull() ?: 0
//                if (minPrice <= maxPrice) {
//                    binding.priceRangeSliderHotel.setValues(minPrice.toFloat(), maxPrice.toFloat())
//                }
//            }
//        })
//
//
//    }

    private fun setupButtons() {
        binding.btnSearch.setOnClickListener {
            performSearch()
        }

        binding.btnReset.setOnClickListener {
            resetSearch()
        }
    }

//    private fun setupDatePickers() {
//        binding.etCheckInDateHotel.setOnClickListener {
//            showDatePicker(true)
//        }
//
//        binding.etCheckOutDateHotel.setOnClickListener {
//            showDatePicker(false)
//        }
//    }

//    private fun setupStarRatingSelection() {
//        val starRatingToggles = mapOf(
//            binding.toggle5StarHotel to 5,
//            binding.toggle4StarHotel to 4,
//            binding.toggle3StarHotel to 3,
//            binding.toggle2StarHotel to 2,
//            binding.toggle1StarHotel to 1
//        )
//
//        starRatingToggles.forEach { (toggle, stars) ->
//            toggle.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    selectedStarRatings.add(stars)
//                } else {
//                    selectedStarRatings.remove(stars)
//                }
//            }
//        }
//    }

//    private fun showDatePicker(isCheckIn: Boolean) {
//        val calendar = Calendar.getInstance()
//        val year = calendar.get(Calendar.YEAR)
//        val month = calendar.get(Calendar.MONTH)
//        val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//        val datePickerDialog = DatePickerDialog(
//            requireContext(),
//            { _, selectedYear, selectedMonth, selectedDay ->
//                val formattedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
//                if (isCheckIn) {
//                    binding.etCheckInDateHotel.setText(formattedDate)
//                    checkInDate = formattedDate
//                } else {
//                    binding.etCheckOutDateHotel.setText(formattedDate)
//                    checkOutDate = formattedDate
//                }
//            },
//            year,
//            month,
//            day
//        )
//
//        // Set minimum date to today for check-in
//        if (isCheckIn) {
//            datePickerDialog.datePicker.minDate = System.currentTimeMillis()
//        } else {
//            // For check-out, set minimum date to check-in date if it exists
//            if (!checkInDate.isNullOrEmpty()) {
//                val checkInCalendar = Calendar.getInstance()
//                val checkInParts = checkInDate!!.split("/")
//                checkInCalendar.set(
//                    checkInParts[2].toInt(),
//                    checkInParts[1].toInt() - 1,
//                    checkInParts[0].toInt()
//                )
//                datePickerDialog.datePicker.minDate = checkInCalendar.timeInMillis
//            } else {
//                datePickerDialog.datePicker.minDate = System.currentTimeMillis()
//            }
//        }
//
//        datePickerDialog.show()
//    }
//
//
//    private fun setupStarRatingSelection() {
//        // Initialize star rating toggles with their corresponding values
//        val starRatingToggles = mapOf(
//            binding.toggle5StarHotel to 5,
//            binding.toggle4StarHotel to 4,
//            binding.toggle3StarHotel to 3,
//            binding.toggle2StarHotel to 2,
//            binding.toggle1StarHotel to 1
//        )
//
//        // Set up click listeners for each star rating toggle
//        starRatingToggles.forEach { (toggle, stars) ->
//            toggle.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Add the star rating to selected ratings
//                    selectedStarRatings.add(stars)
//                    // Show feedback to user
//                } else {
//                    // Remove the star rating from selected ratings
//                    selectedStarRatings.remove(stars)
//                }
//
//                // Update UI to reflect current selection
//                updateStarRatingUI()
//            }
//        }
//    }
//
//    private fun updateStarRatingUI() {
//        // Update UI elements based on selected star ratings
//        binding.toggle5StarHotel.isChecked = selectedStarRatings.contains(5)
//        binding.toggle4StarHotel.isChecked = selectedStarRatings.contains(4)
//        binding.toggle3StarHotel.isChecked = selectedStarRatings.contains(3)
//        binding.toggle2StarHotel.isChecked = selectedStarRatings.contains(2)
//        binding.toggle1StarHotel.isChecked = selectedStarRatings.contains(1)
//
//    }


    private fun performSearch() {
        // Get price range
        minPrice = binding.etMinPrice.text?.toString()
        maxPrice = binding.etMaxPrice.text?.toString()

        // Validate inputs
        if (selectedPropertyType == null) {
            Toast.makeText(context, "الرجاء اختيار نوع العقار", Toast.LENGTH_SHORT).show()
            return
        }

        if (selectedOperationType == null) {
            Toast.makeText(context, "الرجاء اختيار نوع العملية", Toast.LENGTH_SHORT).show()
            return
        }

        if (selectedWilaya == null) {
            Toast.makeText(context, "الرجاء اختيار الولاية", Toast.LENGTH_SHORT).show()
            return
        }

        // Validate dates if provided
        if (!checkInDate.isNullOrEmpty() && !checkOutDate.isNullOrEmpty()) {
            val checkInParts = checkInDate!!.split("/")
            val checkOutParts = checkOutDate!!.split("/")

            val checkInCalendar = Calendar.getInstance().apply {
                set(checkInParts[2].toInt(), checkInParts[1].toInt() - 1, checkInParts[0].toInt())
            }

            val checkOutCalendar = Calendar.getInstance().apply {
                set(checkOutParts[2].toInt(), checkOutParts[1].toInt() - 1, checkOutParts[0].toInt())
            }

            if (checkOutCalendar.before(checkInCalendar)) {
                Toast.makeText(context, "تاريخ المغادرة يجب أن يكون بعد تاريخ الوصول", Toast.LENGTH_SHORT).show()
                return
            }
        }


        // Validate price range if provided
        if (!minPrice.isNullOrEmpty() && !maxPrice.isNullOrEmpty()) {
            val min = minPrice!!.toIntOrNull()
            val max = maxPrice!!.toIntOrNull()

            if (min == null || max == null) {
                Toast.makeText(context, "الرجاء إدخال قيم صحيحة للسعر", Toast.LENGTH_SHORT).show()
                return
            }

            if (min > max) {
                Toast.makeText(context, "السعر الأدنى يجب أن يكون أقل من السعر الأقصى", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Create search parameters
        val searchParams = mapOf(
            "propertyType" to selectedPropertyType,
            "operationType" to selectedOperationType,
            "wilaya" to selectedWilaya,
            "baladia" to selectedBaladia,
            "minPrice" to minPrice,
            "maxPrice" to maxPrice,
            "features" to selectedFeatures.toList(),
            "furnished" to selectedFurnishedStatus,
            "furnished" to selectedFurnishedStatus,
            "checkInDate" to checkInDate,
            "checkOutDate" to checkOutDate,
            "starRatings" to selectedStarRatings.toList()
        )

        // TODO: Implement search logic with the parameters
        Toast.makeText(context, "جاري البحث...", Toast.LENGTH_SHORT).show()
    }

    private fun resetSearch() {
        // Reset property type selection
        binding.toggleRealestate.isChecked = true
        binding.toggleHotels.isChecked = false
        selectedPropertyType = null

        // Reset operation type selection
        binding.toggleRent.isChecked = false
        binding.toggleSale.isChecked = false
        binding.toggleExchange.isChecked = false
        selectedOperationType = null

        // Reset features selection
        binding.toggleParking.isChecked = false
        binding.toggleGarden.isChecked = false
        binding.togglePool.isChecked = false
        binding.toggleSecurity.isChecked = false
        selectedFeatures.clear()

        // Reset furnished status
        binding.toggleFurnishedYes.isChecked = false
        binding.toggleFurnishedNo.isChecked = false
        binding.toggleFurnishedDoesntMatter.isChecked = false
        selectedFurnishedStatus = null

        // Reset price range
        binding.etMinPrice.text?.clear()
        binding.etMaxPrice.text?.clear()
        binding.priceRangeSlider.setValues(0f, 100000f)

        // Reset hotel price range
//        binding.etMinPriceHotel.text?.clear()
//        binding.etMaxPriceHotel.text?.clear()
//        binding.priceRangeSliderHotel.setValues(0f, 100000f)

        // Reset dates
//        binding.etCheckInDateHotel.text?.clear()
//        binding.etCheckOutDateHotel.text?.clear()
        checkInDate = null
        checkOutDate = null

        // Reset star ratings
//        binding.toggle5StarHotel.isChecked = false
//        binding.toggle4StarHotel.isChecked = false
//        binding.toggle3StarHotel.isChecked = false
//        binding.toggle2StarHotel.isChecked = false
//        binding.toggle1StarHotel.isChecked = false
        selectedStarRatings.clear()

        // Reset location
        binding.spinnerWilaya.setText("", false)
        binding.spinnerBaladia.setText("", false)
        selectedWilaya = null
        selectedBaladia = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
