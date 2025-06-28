package com.noureddine.eqar.utils

import java.text.NumberFormat

class Constants {


    // Algerian states (Wilayas)
    companion object {

        fun formatWithCommas(number: Long): String {
            val formatted = NumberFormat.getInstance().format(number)
            return formatted
        }

        val wilayasFr = listOf(
            "01 - Adrar", "02 - Chlef", "03 - Laghouat", "04 - Oum El Bouaghi", "05 - Batna",
            "06 - Béjaïa", "07 - Biskra", "08 - Béchar", "09 - Blida", "10 - Bouira",
            "11 - Tamanrasset", "12 - Tébessa", "13 - Tlemcen", "14 - Tiaret", "15 - Tizi Ouzou",
            "16 - Alger", "17 - Djelfa", "18 - Jijel", "19 - Sétif", "20 - Saïda",
            "21 - Skikda", "22 - Sidi Bel Abbès", "23 - Annaba", "24 - Guelma", "25 - Constantine",
            "26 - Médéa", "27 - Mostaganem", "28 - M'Sila", "29 - Mascara", "30 - Ouargla",
            "31 - Oran", "32 - El Bayadh", "33 - Illizi", "34 - Bordj Bou Arréridj",
            "35 - Boumerdès", "36 - El Tarf", "37 - Tindouf", "38 - Tissemsilt", "39 - El Oued",
            "40 - Khenchela", "41 - Souk Ahras", "42 - Tipaza", "43 - Mila", "44 - Aïn Defla",
            "45 - Naâma", "46 - Aïn Témouchent", "47 - Ghardaïa", "48 - Relizane",
            "49 - Timimoun", "50 - Bordj Badji Mokhtar", "51 - Ouled Djellal", "52 - Béni Abbès",
            "53 - In Salah", "54 - In Guezzam", "55 - Touggourt", "56 - Djanet",
            "57 - El M'Ghair", "58 - El Meniaa"
        )


        // Complete Map of Wilayas to their municipalities (Baladias)
        val wilayaToBaladiasFr = mapOf(
            "01 - Adrar" to listOf(
                "Adrar", "Tamentit", "Reggane", "In Zghmir", "Tit", "Ksar Kaddour", "Tsabit",
                "Timimoun", "Ouled Saïd", "Zaouiet Kounta", "Aoulef", "Timiaouine", "Tinerkouk",
                "Deldoul", "Charouine", "Sebaa", "Ouled Ahmed Tammi", "Bouda", "Aougrout",
                "Talmine", "Tamest", "Fenoughil", "Tamantit", "Reggan", "Sali", "Akabli",
                "Metarfa", "Ouled Aissa"
            ),

            "02 - Chlef" to listOf(
                "Chlef", "Ténès", "Benairia", "El Karimia", "Tadjena", "Taougrit", "Beni Haoua",
                "Sobha", "Harchoun", "Ouled Farès", "Sidi Aakcha", "Boukadir", "Beni Rached",
                "Talassa", "Herenfa", "Oued Goussine", "Dahra", "Ouled Abbes", "Sendjas",
                "Zeboudja", "Oued Sly", "Abou El Hassen", "El Marsa", "Chettia", "Sidi Abderrahmane",
                "Moussadek", "El Hadjadj", "Labiod Medjadja", "Oued Rhiou", "Ouled Ben Abdelkader",
                "Bouzeghaia", "Breira", "Bentaiba", "Ain Merane", "Oum Drou"
            ),

            "03 - Laghouat" to listOf(
                "Laghouat", "Ksar El Hirane", "Bennasser Benchohra", "Sidi Makhlouf", "Hassi Delaa",
                "Hassi R'Mel", "Aïn Madhi", "Tadjmout", "Kheneg", "Gueltat Sidi Saad", "Aflou",
                "El Assafia", "Oued Morra", "Oued M'Zi", "El Ghicha", "Hadj Mechri", "Sebgag",
                "Taouiala", "Tadjrouna", "Krakda", "Sidi Bouzid", "El Houaita", "Brida", "Benacer Benchohra"
            ),

            "04 - Oum El Bouaghi" to listOf(
                "Oum El Bouaghi", "Aïn Beida", "Aïn M'Lila", "Behir Chergui", "El Amiria", "Sigus",
                "El Belala", "Aïn Babouche", "Berriche", "Ouled Hamla", "Dhalaa", "Aïn Kercha",
                "Hanchir Toumghani", "El Djazia", "Aïn Diss", "Fkirina", "Souk Naamane", "Zorg",
                "El Fedjoudj Boughrara Saoudi", "Ouled Zouaï", "Bir Chouhada", "Ksar Sbahi", "Oued Nini",
                "Meskiana", "Aïn Fekroun", "Rahbat", "Aïn Zitoun", "Canrobert", "Ouled Gacem"
            ),

            "05 - Batna" to listOf(
                "Batna", "Ghassira", "Maafa", "Merouana", "Seriana", "Menaa", "El Madher",
                "Tazoult-Lambese", "N'Gaous", "Guigba", "Inoughissen", "Ouyoun El Assafir", "Djerma",
                "Bitam", "Abdelkader", "Arris", "Kimmel", "Tilatou", "Aïn Djasser", "Ouled Sellam",
                "Tigherghar", "Aïn Yagout", "Fesdis", "Sefiane", "Rahbat", "Tighanimine", "Lemsane",
                "Ksar Bellezma", "Seggana", "Ichmoul", "Foum Toub", "Beni Foudhala El Hakania",
                "Oued El Ma", "Talkhamt", "Bouzina", "Chemora", "Oued Chaaba", "Taxlent",
                "Gosbat", "Ouled Aouf", "Boumagueur", "Barika", "Djezzar", "T'Kout", "Aïn Touta",
                "Hidoussa", "Teniet El Abed", "Oued Taga", "Ouled Si Slimane", "Zanat El Beida",
                "M'Doukal", "Ouled Fadel", "Timgad", "Ras El Aioun", "Chir", "Chemora", "Lazrou",
                "Boumia", "Boulhilat", "Ghassira"
            ),

            "06 - Béjaïa" to listOf(
                "Béjaïa", "Amizour", "Ferraoun", "Taourirt Ighil", "Chellata", "Tamokra", "Timezrit",
                "Souk El Tenine", "M'Cisna", "Tinebdar", "Tichy", "Semaoun", "Kendira", "Tifra",
                "Ighram", "Amalou", "Ighil Ali", "Fenaia Il Maten", "Toudja", "Darguina", "Sidi Ayad",
                "Aokas", "Beni Djellil", "Adekar", "Akbou", "Seddouk", "Tazmalt", "Ait Rizine",
                "Chemini", "Souk Oufella", "Taskriout", "Tibane", "Tala Hamza", "Barbacha", "Beni Ksila",
                "Oued Ghir", "Ighil Nacer", "Tamridjet", "Taghzout", "Aït Smaïl", "Boukhelifa",
                "Tizi N'Berber", "Beni Maouche", "Akfadou", "Leflaye", "Kherrata", "Draâ Kaid",
                "Tamokra", "Bouhamza", "Beni Mellikeche", "Sidi Aïch", "El Kseur", "Melbou",
                "Boudjellil", "Ait Mellouk", "Ait Rezine"
            ),

            "07 - Biskra" to listOf(
                "Biskra", "Sidi Okba", "Chetma", "Foughala", "Branis", "Zeribet El Oued", "Sidi Khaled",
                "M'Chouneche", "El Kantara", "Aïn Naga", "Zeribet El Oued", "El Feid", "Djemorah",
                "Tolga", "Lioua", "Lichana", "Ouled Djellal", "Besbes", "El Ghrous", "Meziraa",
                "Bouchagroune", "El Haouch", "Aïn Zaatout", "El Outaya", "Doucen", "Chaïba", "Khanguetr",
                "Ouled Sassi", "Ras El Miaad", "Mechouneche", "Oumache", "Mlili", "Khoubana", "Ourlal"
            ),

            "08 - Béchar" to listOf(
                "Béchar", "Kénadsa", "Lahmar", "Beni Ounif", "Tabelbala", "Igli", "Mogheul",
                "Abadla", "Kerzaz", "Timoudi", "Ouled Khodeir", "Erg Ferradj", "Boukais",
                "Mougheul", "Tamtert", "Beni Ikhlef", "Tagda", "El Ouata", "Béni Abbès",
                "Ouled Khoudir", "Ksabi", "Timoudi", "Meridja", "Machraa Houari Boumediene"
            ),

            "09 - Blida" to listOf(
                "Blida", "Chréa", "Boufarik", "Larbaa", "Oued Alleug", "Chiffa", "Hammam Melouane",
                "Ben Khelil", "Soumaa", "Mouzaia", "El Affroun", "Chebli", "Bouinan", "Ouled Slama",
                "Bougara", "Guerrouaou", "Aïn Romana", "Joubour", "Zeboudja", "Oued El Alleug",
                "Souhane", "Ghrib", "Aïn El Hammam", "Ouled Yaïch", "Chiffa", "Oued Djer", "Meftah"
            ),

            "10 - Bouira" to listOf(
                "Bouira", "Aïn Bessem", "Bir Ghbalou", "Bordj Okhriss", "El Hachimia", "Aomar",
                "Chorfa", "Kadiria", "Djebahia", "Aïn El Hadjar", "Dirah", "Saharidj", "Souk El Khemis",
                "Haizer", "Lakhdaria", "Maala", "Hoceinia", "Taghzout", "Ridane", "Bechloul",
                "Boukram", "Aghbalou", "Zbarbar", "Aïn Turk", "Dechmia", "Aïn Laloui", "Aïn El Hadjar",
                "M'Chedallah", "Sour El Ghozlane", "Aïn Bessem", "El Esnam", "Raouraoua", "Guerrouma",
                "El Adjiba", "Taguedit", "Ath Mansour Taourirt", "Hadjout", "Ain Turk", "Ouamri",
                "El Mokrani", "Aïn Laloui", "Aïn El Hadjar", "Aït Laziz", "Bouderbala", "El Hakimia"
            ),

            "11 - Tamanrasset" to listOf(
                "Tamanrasset", "Abalessa", "In Ghar", "Tin Zaouatine", "Tazrouk", "Aïn Amguel",
                "Aïn Salah", "Tazhout", "Idlès", "Tin Zaouatine", "Silet", "Aïn Guezzam", "Iferouene"
            ),

            "12 - Tébessa" to listOf(
                "Tébessa", "Bir El Ater", "Cheria", "Stah Guentis", "El Aouinet", "Lahouidjbet",
                "Safsaf El Ouesra", "Hammamet", "Négrine", "Bir Mokkadem", "El Kef", "Ferkane",
                "Boukhadra", "Bekkaria", "Aïn Zerga", "El Meridj", "Boulhaf Dir", "Bedjene",
                "El Morabet", "Gourig", "Bir Dheheb", "Ogla Melha", "Aïn Zerga", "Thlidjene",
                "El Ogla", "El Kouif", "Morsott", "El Houidjbet"
            ),

            "13 - Tlemcen" to listOf(
                "Tlemcen", "Chetouane", "Hennaya", "Maghnia", "Remchi", "Hammam Boughrara", "Ouled Mimoun",
                "Aïn Tallout", "El Febala", "Aïn Ghoraba", "Ouled Riyah", "Bouhlou", "Souk Ahras",
                "Sidi Abdelli", "Sebaa Chioukh", "Beni Mester", "Fellaoucen", "Azails", "Aïn Nehala",
                "Beni Smiel", "Ghazaouet", "Souani", "Djebala", "El Gor", "Oued Lakhdar", "Ain Fezza",
                "Ouled Mimoun", "Beni Ouarsous", "Souahlia", "Beni Boussaid", "Marsa Ben M'Hidi",
                "Nedroma", "Sidi Medjahed", "Beni Snous", "Tianet", "Bab El Assa", "Dar Yaghmoracen",
                "Honaine", "Tianet", "Sebdou", "Beni Bahdel", "Sidi Djillali", "Bensekrane",
                "Aïn Kebira", "Sidi Senoussi", "Beni Semiel", "Terny Beni Hediel", "Zenata",
                "Ouled Riyah", "Amieur", "Ain Fezza"
            ),

            "14 - Tiaret" to listOf(
                "Tiaret", "Aïn Bouchekif", "Aïn Zarit", "Aïn Dheb", "Aïn Kermes", "Dahmouni",
                "Rahouia", "Mahdia", "Sougueur", "Sidi Ali Mellal", "Aïn El Hadid", "Serghine",
                "Bougara", "Faidja", "Rechaiga", "Nadorah", "Tagdemt", "Oued Lilli", "Mechraa Safa",
                "Hamadia", "Chehaima", "Takhemaret", "Sidi Hosni", "Sebaine", "Tousnina", "Frenda",
                "Aïn Kermes", "Ksar Chellala", "Rechaiga", "Zmalet El Emir Abdelkader", "Madna",
                "Sebt", "Djebilet Rosfa", "Sidi Abdelghani", "Guertoufa", "Mellakou", "Sidi Bakhti",
                "Chehaima", "Medrissa", "Djillali Ben Amar", "Aïn Bouchekif", "Faidja", "Naima",
                "Medroussa", "Sidi Ali Mellal", "Mechraa Safa", "Chehaima"
            ),

            "15 - Tizi Ouzou" to listOf(
                "Tizi Ouzou", "Aïn El Hammam", "Akbil", "Freha", "Souamaa", "Mechtarass", "Irdjen",
                "Timizart", "Makouda", "Draa El Mizan", "Tizi Gheniff", "Bounouh", "Ait Chafaa",
                "Frikat", "Beni Aissi", "Beni Zmenzer", "Iferhounene", "Azazga", "Illoula Oumalou",
                "Yakouren", "Larbaâ Nath Irathen", "Tizi Rached", "Zekri", "Ouaguenoun", "Aïn Zaouia",
                "M'Kira", "Ait Yahia", "Tirmitine", "Akerrou", "Yatafen", "Beni Ziki", "Draâ Ben Khedda",
                "Ouadhias", "Azeffoun", "Tigzirt", "Ait Aggouacha", "Ouacif", "Mizrana", "Imsouhal",
                "Tadmaït", "Aït Boumahdi", "Abi Youcef", "Beni Douala", "Illilten", "Bouzeguène",
                "Ait Yahia Moussa", "Souk El Tenine", "Ait Khelili", "Sidi Namane", "Iboudraren",
                "Aghribs", "Iflissen", "Boudjima", "Ait Oumalou", "Tizi N'Tleta", "Beni Ouglis",
                "Ait Toudert", "Ait Bouaddou", "Assi Youcef", "Ait Aissa Mimoun", "Ait Boumahdi",
                "Akerrou", "Imsouhal", "Ait Khellili", "Maatka", "Ait Yahia"
            ),

            "16 - Alger" to listOf(
                "Alger Centre", "Bab El Oued", "Bologhine", "Casbah", "Oued Koriche", "Bir Mourad Raïs",
                "Birkhadem", "Bourouba", "El Biar", "Hussein Dey", "Kouba", "Les Eucalyptus", "Rais Hamidou",
                "Bab Ezzouar", "Baraki", "Dar El Beïda", "Douera", "Draria", "El Harrach", "El Magharia",
                "Oued Smar", "Rouiba", "Sidi Moussa", "Aïn Taya", "Bordj El Bahri", "Bordj El Kiffan",
                "El Marsa", "Hamma Bouziane", "Mohammadia", "Reghaia", "Saoula", "Staoueli", "Zeralda",
                "Aïn Benian", "Cheraga", "Dely Ibrahim", "Hammamet", "Ouled Fayet", "Sidi Abdellah",
                "Tessala El Merdja", "Mahelma", "Rahmania", "Souidania", "Khraicia", "Meftah", "Beni Mered",
                "Bouinan", "Chebli", "Eucalyptus", "Hraoua", "Ouled Chebel", "Saoula", "Tessala El Merdja"
            ),

            "17 - Djelfa" to listOf(
                "Djelfa", "Moudjbara", "El Guedid", "Hassi Bahbah", "Aïn El Ibel", "Aïn Oussera",
                "Birine", "Bouira Lahdab", "Charef", "Deldoul", "Dar Chioukh", "El Khemis", "El Idrissia",
                "Douis", "Faidh El Botma", "Guettara", "Hassi El Euch", "Messaad", "M'Liliha", "Sed Rahal",
                "Selmana", "Sidi Baizid", "Sidi Ladjel", "Taadmit", "Zaafrane", "Zaccar", "Ain Maabed",
                "Benhar", "Benyagoub", "Had Sahary", "Hassi Fedoul", "Oum Laadham", "Sidi Bouzid",
                "Ain Chouhada", "El Jadida", "Guernini", "Hassi Delaa"
            ),

            "18 - Jijel" to listOf(
                "Jijel", "Eraguene", "El Aouana", "Ziama Mansouria", "Taher", "Emir Abdelkader",
                "Chekfa", "Chahna", "El Milia", "Sidi Marouf", "Settara", "El Ancer", "Jijel",
                "Kaous", "Ghebala", "Bouraoui Belhadef", "Djimla", "Selma Benziada", "Boudriaa Beni Yadjis",
                "Kheiri Oued Adjoul", "Texenna", "Djemaa Beni Habibi", "Bordj Taher", "Ouled Yahia Khedrouch",
                "Ouled Rabah", "Ouadjana", "Sidi Abdelaziz", "Ziama Mansouria"
            ),

            "19 - Sétif" to listOf(
                "Sétif", "Aïn El Kebira", "Aïn Sebt", "Ouled Sidi Ahmed", "Beïda Bordj", "El Eulma",
                "Aïn Azel", "Mezloug", "Beni Aziz", "Ouled Tebben", "Rosfa", "Ouled Addouane",
                "Belaa", "Aïn Roua", "Tixter", "Ras El Oued", "Reggane", "Tachouda", "Bousselam",
                "El Ouricia", "Taya", "Aïn Legradj", "Ait Naoual Mezada", "Guidjel", "Aïn Oulmane",
                "Serdj El Ghoul", "Harbil", "El Ouldja", "Tizi N'Bechar", "Salit", "Aïn Azal",
                "Avoine", "Beni Chebana", "Ouled Si Ahmed", "Boutaleb", "Bazer Sakhra", "Hamam Soukhna",
                "Bir Haddada", "Sidi Mesrane", "El Eulma", "Djemila", "Beni Fouda", "Tachouda",
                "Amoucha", "Aïn Lahdjar", "Bougaa", "Darrem", "Tella", "Hammam Guergour", "Ait Tizi",
                "Maouaklane", "Guenzet", "Talaifacene", "Beidha Bordj", "El Ouricia", "Hamma",
                "Maaouia", "Aïn Arnat", "Aïn-Abessa", "Dehamcha", "Babor", "Oued El Bared",
                "Ouled Sabor", "Ouled Sidi Ahmed", "Salah Bey", "Aïn Azal", "Bir El Arch", "Beni Aziz"
            ),

            "20 - Saïda" to listOf(
                "Saïda", "Doui Thabet", "Ouled Brahim", "Moulay Larbi", "Youb", "Hounet",
                "Sidi Amar", "Sidi Boubekeur", "El Hassasna", "Maamora", "Sidi Yacoub", "Tircine",
                "Ain El Hadjar", "Ouled Khaled", "Sidi Ahmed", "Ain Soltane"
            ),

            "21 - Skikda" to listOf(
                "Skikda", "El Hadaiek", "Azzaba", "Djendel Saadi Mohamed", "Ain Charchar", "Bekkouche Lakhdar",
                "Benazouz", "Es Sebt", "Ouled Attia", "Oued Zhour", "Zerdezas", "Ouled Hebaba",
                "Sidi Mezghiche", "Emjez Edchich", "Beni Oulbane", "Ain Bouziane", "Ramdane Djamel",
                "Bin El Ouiden", "El Arrouch", "Salah Bouchaour", "Tamalous", "Ain Kechra", "Khenag Meyoun",
                "Hamadi Krouma", "El Ghedir", "Bouchtata", "Oum Toub", "Beni Bachir", "Kerkera",
                "Ouled Attia", "Filfila", "Cheraia", "Bidha", "Messaoudene", "Beni Zid", "Zeradezas",
                "Collo", "Zitouna", "Ain Zouit", "Kanoua", "El Marsa", "Ben Azzouz"
            ),

            "22 - Sidi Bel Abbès" to listOf(
                "Sidi Bel Abbès", "Tessala", "Sfisef", "Ain Thrid", "Merine", "Ras El Ma", "Sarno",
                "Ain Tindamine", "Hassi Zahana", "Tilmouni", "Sidi Lahcene", "Ain Kada", "Moulay Slissen",
                "Youb", "Tessala", "Telagh", "Sidi Hamadouche", "Mostefa Ben Brahim", "Sidi Khaled",
                "Ain El Berd", "Tamayoute", "Benachiba Chelia", "Dhaya", "Zehana", "Ouriahet El Ghaaba",
                "Sidi Brahim", "Mustafa Ben Brahiem", "Sidi Yacoub", "Lamtar", "Oued Sefioun",
                "Ain Tindamine", "Ain Thrid", "Belarbi", "Ben Badis", "Boukhanafis", "Chetouane Belaila",
                "El Hacaiba", "Hassi Dahou", "Hassi Zahana", "Makedra", "Marhoum", "Mcid", "Merine",
                "Mezaourou", "Mostefa Ben Brahim", "Moulay Slissen", "Oued Sebaa", "Oued Sefioun",
                "Ras El Ma", "Redjem Demouche", "Sehala Thaoura", "Sfisef", "Sidi Ali Benyoub",
                "Sidi Ali Boussidi", "Sidi Brahim", "Sidi Chaib", "Sidi Dahou Dechara", "Sidi Hamadouche",
                "Sidi Khaled", "Sidi Lahcene", "Sidi Yacoub", "Tabia", "Tamayoute", "Telagh",
                "Tenira", "Tessala", "Tilmouni", "Zerouala"
            ),

            "23 - Annaba" to listOf(
                "Annaba", "El Hadjar", "Ain Berda", "El Bouni", "Sidi Amar", "Chorfa", "Treat",
                "Ain El Berda", "El Eulma", "Berrahal", "Chetaibi", "Oued El Aneb", "Seraidi",
                "Cheurfa"
            ),

            "24 - Guelma" to listOf(
                "Guelma", "Bouchegouf", "Nechmaya", "Roknia", "Ras El Agba", "Bordj Sabath",
                "Belkheir", "Khezaras", "Hammam Debagh", "Oued Zenati", "Tamlouka", "Dahouara",
                "Heliopolis", "Hammam N'Bail", "Ain Sandel", "Medjez Amar", "Boumahra Ahmed",
                "Khezaras", "Guelaat Bou Sbaa", "Medjez Sfa", "Ain Makhlouf", "Houari Boumediene",
                "Ain Larbi", "Fedj M'Zala", "Roknia", "Oued Fragha", "Beni Mezline", "Ben Djerrah",
                "Bordj Sabath", "Ain Hessainia", "Sellaoua Announa", "Ain Ben Beida"
            ),

            "25 - Constantine" to listOf(
                "Constantine", "El Khroub", "Hamma Bouziane", "Ibn Ziad", "Didouche Mourad", "Zighoud Youcef",
                "Aïn Abid", "Aïn Smara", "Beni Hamiden", "Ouled Rahmoune", "Ibn Badis", "Messaoud Boudjriou",
                "Aïn El Bey", "Aïn Kerma", "Ouled Rahmoune", "El Meridj", "Beni Hamiden", "Ain Smara"
            ),

            "26 - Médéa" to listOf(
                "Médéa", "Ouzera", "Aïn Boucif", "Ouamri", "Si Mahdjoub", "Derrag", "El Azizia",
                "Damiat", "Boughezoul", "Chellalet El Adhaoura", "Bir Ben Laabed", "El Ouinet",
                "Mihoub", "Maghraoua", "Baata", "Tamesguida", "Khams Djouamaa", "Souagui",
                "Beni Slimane", "Djelida", "Des Deux Bassins", "Boghar", "Tafraout", "Cheniguel",
                "Ain Ouksir", "Aziz", "Oued Harbil", "Tablat", "Guelb El Kebir", "Bouskene",
                "El Hamdania", "Benchicao", "Zoubiria", "Fid Hammad", "Saneg", "Sidi Demed",
                "Sidi Naamane", "Ksar El Boukhari", "El Guelbelkebir", "Ain Ouksir", "Bouchrahil",
                "Hannacha", "Zemmoura", "Oum El Djellil", "Ouled Antar", "Sidi Zahar", "Tizi Mahdi",
                "Chahbouna", "Tlatet Eddouair", "Mezghana", "Chelalet Eladhaoura", "Draa Essamar",
                "Rebaia", "Sedraia", "Sidi Ziane", "Ain Boucif", "Ouled Brahim", "Ouled Hellal",
                "Berrouaghia", "Seghouane", "Sidi Naamane", "Ben Chicao", "El Azizia", "Ouled Deide",
                "Ain Bourek", "Medjebar", "Sidi Rabie", "El Omaria", "Ouled Maimon"
            ),

            "27 - Mostaganem" to listOf(
                "Mostaganem", "Sayada", "Fornaka", "Stidia", "Ain Nouissy", "Hassi Mameche", "Ain Tadles",
                "Sour", "Ouled Maalah", "Sidi Ali", "Abdelmalek Ramdane", "Ain Boudinar", "Tazgait",
                "Sidi Belattar", "El Matmar", "Mansourah", "Souaflia", "Bouguirat", "Sirat", "Ain Sidi Cherif",
                "Mesra", "Mazagran", "Benabdelmalek Ramdane", "Kheir Eddine", "Sidi Lakhdar", "Touahria",
                "Nekmaria", "Safi", "Khadra", "Ouled Boughalem", "Hadjadj", "Oued El Kheir", "Stidia",
                "Achaacha"
            ),

            "28 - M'Sila" to listOf(
                "M'Sila", "Magra", "Hammam Dalaa", "Ouled Derraj", "Tarmount", "Maarif", "Ouanougha",
                "Sidi Aissa", "Berhoum", "Bou Saada", "Ouled Sidi Brahim", "Sidi Ameur", "Tamsa",
                "Ben Srour", "Mohamed Boudiaf", "Ouled Addi Guebala", "Belaiba", "Sidi Hadjeres",
                "Djebel Messaad", "Hammam Dalaa", "Ain El Hadjel", "Zarzour", "Khoubana", "Mchouneche",
                "Benzouh", "Ouled Slimane", "El Houamed", "Ain El Melh", "Ouled Mansour", "Maadid",
                "Souamaa", "Ain Fares", "Chellal", "Khettouti Sed Eldjir", "Slim", "Dehahna",
                "Bouti Sayeh", "Bir Foda", "Sidi Aissa", "Medjedel", "Ouled Madhi", "Benaissa",
                "Ouled Sidi Brahim", "Ain Khadra", "Menaa", "Hammam Dalaa", "Ouled Derradj"
            ),

            "29 - Mascara" to listOf(
                "Mascara", "Bouhanifia", "Tighennif", "Oued El Abtal", "Ain Fares", "Sig", "Mamounia",
                "Aouf", "Alaimia", "El Bordj", "Ras Ain Amirouche", "Khalouia", "El Menaouer",
                "Sidi Kada", "Zelamta", "Oued Taria", "Sidi Abdelmoumene", "Ferraguig", "El Gaada",
                "Chorfa", "Hachem", "Mohammadia", "Sidi Abdeldjebar", "Nesmoth", "Ain Fekan",
                "Guerdjoum", "El Hachem", "Sehailia", "Frocha", "Matemore", "Makda", "Oggaz",
                "Benian", "Sedjerara", "Mokhda", "Ghriss", "Maoussa", "Bou Henni", "El Keurt",
                "Oued El Abtal", "Ras Ain Amirouche", "Sidi Abdelmoumene", "Tizi"
            ),

            "30 - Ouargla" to listOf(
                "Ouargla", "N'Goussa", "Hassi Messaoud", "Rouissat", "Ain Beida", "Sidi Khouiled",
                "Hassi Ben Abdallah", "Temacine", "Touggourt", "Nezla", "Zaouia El Abidia", "El Alia",
                "Blidet Amor", "Taibet", "Benaceur", "El Borma", "Hassi El Gara", "Sidi Slimane",
                "El Hadjira", "Megarine", "Djamaa", "Umm Es Thiour", "Still", "M'Naguer", "Hassi Messaoud"
            ),

            "31 - Oran" to listOf(
                "Oran", "Bir El Djir", "Hassi Bounif", "Es Senia", "Arzew", "Bethioua", "Mers El Kébir",
                "Aïn El Turk", "Bousfer", "El Ançor", "Oued Tlelat", "Tafraoui", "Sidi Chami", "Messerghine",
                "Boutlelis", "Aïn Kerma", "Ben Freha", "Hassi Ben Okba", "Hassi Mefsoukh", "Sidi Ben Yebka",
                "El Braya", "Gdyel", "Ain El Bia", "Marsat El Hadjadj", "Ain Kerma", "Boufatis", "Hassi Bounif"
            ),

            "32 - El Bayadh" to listOf(
                "El Bayadh", "Rogassa", "Stitten", "Brezina", "Ghassoul", "Bougtob", "El Kheither",
                "Kef El Ahmar", "Boualem", "Ain El Orak", "Arbaouat", "Brida", "Cheguig", "El Mehara",
                "Tousmouline", "Sidi Amar", "Sidi Slimane", "Sidi Taifour", "Kraakda", "Chellala",
                "Labiodh Sidi Saikh", "Ain Ouarka"
            ),

            "33 - Illizi" to listOf(
                "Illizi", "Djanet", "Bordj Omar Driss", "Debdeb", "In Amenas"
            ),

            "34 - Bordj Bou Arréridj" to listOf(
                "Bordj Bou Arréridj", "Ras El Oued", "Bordj Zemouri", "Mansourah", "Medjana", "Teniet En Nasr",
                "Jaafra", "El Hamadia", "Ain Taghrout", "Bordj Ghedir", "Sidi Embarek", "Ouled Brahem",
                "Ouled Dahmane", "Haraza", "El Mhir", "Ben Daoud", "El Achir", "Ain Tesra", "Bir Kasdali",
                "El Euch", "Ghilasa", "Rabta", "Belimour", "Djaafra", "El Ksour", "Ouled Sidi Brahim",
                "Tixter", "Colla", "Taglait", "Ksour", "Ouled Dahmane", "Tassamert", "Ouled Sidi Brahim"
            ),

            "35 - Boumerdès" to listOf(
                "Boumerdès", "Naciria", "Djinet", "Isser", "Zemmouri", "Si Mustapha", "Tidjelabine",
                "Chabet El Ameur", "Thenia", "Timezrit", "Corso", "Ouled Moussa", "Larbatache",
                "Boudouaou", "Afir", "Bordj Menaiel", "Baghlia", "Sidi Daoud", "Conséquent", "Khemisti",
                "Hammedi", "Ouled Aissa", "Ben Choud", "Dellys", "Ammal", "Beni Amrane", "Souk El Had",
                "Bouzegza Keddara", "Taourga", "Ouled Heddadj", "Leghata", "Beni Amrane", "El Kharrouba",
                "Issers"
            ),

            "36 - El Tarf" to listOf(
                "El Tarf", "Bouhadjar", "Ben M'Hidi", "Boutheldja", "El Aioun", "Souarekh", "Berrihane",
                "Lac des Oiseaux", "Cheffia", "Drean", "Chihani", "Hammam Beni Salah", "Raml Souk",
                "Ain El Assel", "El Chatt", "Zitouna", "Oued Zitoun", "Besbes", "Asfour", "Echatt"
            ),

            "37 - Tindouf" to listOf(
                "Tindouf", "Oum El Assel"
            ),

            "38 - Tissemsilt" to listOf(
                "Tissemsilt", "Bordj Bou Naama", "Theniet El Had", "Lazharia", "Beni Chaib", "Lardjem",
                "Melaab", "Sidi Lantri", "Bordj El Emir Abdelkader", "Layoune", "Khemisti", "Ouled Bessem",
                "Ammari", "Youssoufia", "Sidi Boutouchent", "Larbaa", "Maasem", "Sidi Abed", "Tamalaht",
                "Boucaid", "Beni Lahcene", "Ouled Bessem", "Sidi Slimane"
            ),

            "39 - El Oued" to listOf(
                "El Oued", "Robbah", "Oued El Alenda", "Bayadha", "Nakhla", "Guemar", "Kouinine",
                "Reguiba", "Hamraia", "Taghzout", "Debila", "Hassani Abdelkrim", "Hassi Khalifa",
                "Trifaoui", "Magrane", "Djamaa", "Oum Touyour", "Sidi Aoun", "Tamerlaght", "Tendla",
                "El Ogla", "Mih Ouansa", "Ben Guecha", "Ourmes", "Still", "Taleb Larbi"
            ),

            "40 - Khenchela" to listOf(
                "Khenchela", "Mtoussa", "Kais", "Baghai", "El Hamma", "Ain Touila", "Taouzianat",
                "Bouhmama", "El Oueldja", "Remila", "Cherchar", "Djellal", "Babar", "Tamsa", "Ensigha",
                "Ouled Rechache", "El Mahmal", "Msara", "Yabous", "Khirane", "Chelia"
            ),

            "41 - Souk Ahras" to listOf(
                "Souk Ahras", "Sedrata", "Hanancha", "Mechroha", "Ouled Driss", "Tiffech", "Zaarouria",
                "Taoura", "Drea", "Heddada", "Ain Soltane", "Ain Zana", "Ouled Moumen", "Bir Bouhouche",
                "Safel El Ouiden", "Ragoubet Naam", "Khemissa", "Oum El Adhaim", "Ain Kercha", "Terraguelt",
                "Lahdeb", "Merahna", "Sidi Fredj", "M'Daourouch", "Ouillen"
            ),

            "42 - Tipaza" to listOf(
                "Tipaza", "Menaceur", "Larhat", "Douaouda", "Bourkika", "Khemisti", "Agha Boulkrim",
                "Hetatba", "Sidi Amar", "Chaiba", "Ain Tagourait", "Cherchell", "Damous", "Meurad",
                "Fouka", "Bou Ismail", "Ahmer El Ain", "Bouharoun", "Sidi Ghiles", "Messelmoun",
                "Sidi Rached", "Kolea", "Attatba", "Sidi Semiane", "Bou Haroun", "Hadjeret Ennous",
                "Gouraya"
            ),

            "43 - Mila" to listOf(
                "Mila", "Ferdjioua", "Chelghoum Laid", "Oued Athmania", "Aïn Mellouk", "Telerghma",
                "Oued Seguen", "Tadjenanet", "Benyahia Abderrahmane", "Ain Tine", "El Mechira",
                "Oued Endja", "Ain Beida Harriche", "Minar Zarza", "Amira Arres", "Tessala Lamtai",
                "Grarem Gouga", "Hamala", "Rouached", "Ahmed Rachedi", "Chigara", "Nechmaya",
                "Derradji Bousselah", "Sidi Merouane", "Tiberguent", "Bouhatem", "Zeghaia",
                "Elayadi Barbes", "Sidi Khelifa", "Yahia Beniguecha", "Ouled Khalouf", "Terrai Bainen"
            ),

            "44 - Aïn Defla" to listOf(
                "Aïn Defla", "Khemis Miliana", "Rouina", "Arib", "Djelida", "El Amra", "Barbouche",
                "Djendel", "Oued Chorfa", "Ain Bouyahia", "El Karimia", "Oued Fodda", "Miliana", "Ben Allal",
                "Bir Ould Khelifa", "Bourached", "Khemis Miliana", "Hammam Righa", "Arib", "Ain Torki",
                "Sidi Lakhdar", "Hoceinia", "Tacheta Zougagha", "Ain Benian", "Zeddine", "Oued Djemaa",
                "Bathia", "Tiberkanine", "Belaas", "Ben Allal", "Ain Sultan", "Bourached", "El Maine",
                "Mekhatria", "Ain Bouyahia", "Zeddine"
            ),

            "45 - Naâma" to listOf(
                "Naâma", "Mécheria", "Aïn Sefra", "Tiout", "Sfissifa", "Moghrar", "Assela", "Djeniane Bourzeg",
                "Aïn Ben Khelil", "Makman Ben Amer", "Kasdir", "El Biod"
            ),

            "46 - Aïn Témouchent" to listOf(
                "Aïn Témouchent", "Hammam Bouhadjar", "Aïn Tolba", "Terga", "Aïn Kihal", "Sidi Ben Adda",
                "Aoubellil", "Aghlal", "Beni Saf", "Sidi Safi", "Oulhaça El Gheraba", "Tamzoura", "Chentouf",
                "Sidi Boumediene", "Oued Berkeche", "Aïn El Arbaa", "El Malah", "Chaabat El Leham",
                "Sidi Ouriache", "M'Sirda Fouaga", "Hassi El Ghella", "Hassi Dahdi", "El Amria", "Emir Abdelkader",
                "Oued Sabah", "Ouled Boudjemaa", "Ain Larbaa"
            ),

            "47 - Ghardaïa" to listOf(
                "Ghardaïa", "El Menia", "Dhayet Ben Dhahoua", "Berriane", "Metlili", "El Atteuf", "Ouled Chaneb",
                "Mansourah", "Hassi Fehal", "Hassi El Gara", "Zelfana", "Sebseb", "Bounoura"
            ),

            "48 - Relizane" to listOf(
                "Relizane", "Oued Rhiou", "Belaabes", "Sidi Saada", "Ouled Aissa", "Sidi Lazreg",
                "El Hamadna", "Mazouna", "Kalaa", "Ain Rahma", "Yellel", "Oued Essalem", "Ouarizane",
                "Lahlef", "Beni Dergoun", "Sidi M'Hamed Benaouda", "Hassi Mameche", "Mediouna",
                "Sidi Khettab", "Ammi Moussa", "Zemmoura", "Beni Zenthis", "Souk El Haad", "Djidiouia",
                "El Guettar", "Hamri", "El Matmar", "Ramka", "Mendes", "Sidi M'Hamed Benali", "Ain Tarek",
                "Oued El Djemaa", "Merdja Sidi Abed", "Ouled Sidi Mihoub", "Beni Dergoun", "El Ouldja",
                "Sidi Saada", "Dar Ben Abdelah", "Bendaoud"
            ),

            "49 - Timimoun" to listOf(
                "Timimoun", "Ouled Aissa", "Ouled Said", "Tinerkouk", "Deldoul", "Metarfa", "Talmine"
            ),

            "50 - Bordj Badji Mokhtar" to listOf(
                "Bordj Badji Mokhtar", "Timiaouine", "Tin Zaouatine"
            ),

            "51 - Ouled Djellal" to listOf(
                "Ouled Djellal", "Sidi Khaled", "Besbes", "Chaiba", "Doucen", "Ras El Miaad"
            ),

            "52 - Béni Abbès" to listOf(
                "Béni Abbès", "Tabelbala", "Igli", "Ouled Khoudir", "Tamtert", "Timoudi", "El Ouata",
                "Kerzaz", "Ksabi"
            ),

            "53 - In Salah" to listOf(
                "In Salah", "Foggaret Ezzaouia", "In Ghar"
            ),

            "54 - In Guezzam" to listOf(
                "In Guezzam", "Tin Zaouatine"
            ),

            "55 - Touggourt" to listOf(
                "Touggourt", "Tebesbest", "Nezla", "El Alia", "Temacine", "Blidet Amor", "Taibet",
                "Megarine", "M'Naguer", "Sidi Slimane", "Zaouia El Abidia"
            ),

            "56 - Djanet" to listOf(
                "Djanet", "Bordj El Houasse"
            ),

            "57 - El M'Ghair" to listOf(
                "El M'Ghair", "Djamaa", "Oum Touyour", "Sidi Aoun", "Ourmes", "Still"
            ),

            "58 - El Meniaa" to listOf(
                "El Meniaa", "Hassi Gara", "Hassi Fehal"
            )
        )


        val wilayasAr = listOf(
            "01 - أدرار", "02 - الشلف", "03 - الأغواط", "04 - أم البواقي", "05 - باتنة",
            "06 - بجاية", "07 - بسكرة", "08 - بشار", "09 - البليدة", "10 - البويرة",
            "11 - تمنراست", "12 - تبسة", "13 - تلمسان", "14 - تيارت", "15 - تيزي وزو",
            "16 - الجزائر", "17 - الجلفة", "18 - جيجل", "19 - سطيف", "20 - سعيدة",
            "21 - سكيكدة", "22 - سيدي بلعباس", "23 - عنابة", "24 - قالمة", "25 - قسنطينة",
            "26 - المدية", "27 - مستغانم", "28 - المسيلة", "29 - معسكر", "30 - ورقلة",
            "31 - وهران", "32 - البيض", "33 - إليزي", "34 - برج بوعريريج",
            "35 - بومرداس", "36 - الطارف", "37 - تندوف", "38 - تيسمسيلت", "39 - الوادي",
            "40 - خنشلة", "41 - سوق أهراس", "42 - تيبازة", "43 - ميلة", "44 - عين الدفلى",
            "45 - النعامة", "46 - عين تموشنت", "47 - غرداية", "48 - غليزان",
            "49 - تيميمون", "50 - برج باجي مختار", "51 - أولاد جلال", "52 - بني عباس",
            "53 - عين صالح", "54 - عين قزام", "55 - تقرت", "56 - جانت",
            "57 - المغير", "58 - المنيعة"
        )

        // خريطة كاملة للولايات إلى بلدياتها
        val wilayaToBaladiasAr = mapOf(
            "01 - أدرار" to listOf(
                "أدرار", "تامنطيط", "رقان", "إين زغمير", "تيط", "قصر قدور", "تسابيت",
                "تيميمون", "أولاد سعيد", "زاوية كنتة", "أولف", "تيمياوين", "تينركوك",
                "دلدول", "شاروين", "سبع", "أولاد أحمد تيمي", "بودة", "أوقروت",
                "طالمين", "تاماست", "فنوغيل", "تامنطيط", "رقان", "سالي", "أقبلي",
                "متارفة", "أولاد عيسى"
            ),

            "02 - الشلف" to listOf(
                "الشلف", "تنس", "بنايرية", "الكريمية", "تاجنة", "تاوقريت", "بني حواء",
                "صبحة", "حرشون", "أولاد فارس", "سيدي عكاشة", "بوقادير", "بني راشد",
                "طلاسة", "هرنفة", "وادي قوسين", "الظهرة", "أولاد عباس", "سنجاس",
                "زبوجة", "وادي سلي", "أبو الحسن", "المرسى", "الشطية", "سيدي عبد الرحمن",
                "موسادق", "الحجاج", "لعبيود مجاجة", "وادي رهيو", "أولاد بن عبد القادر",
                "بوزغاية", "بريرة", "بنطيبة", "عين مران", "أم الدرو"
            ),

            "03 - الأغواط" to listOf(
                "الأغواط", "قصر الحيران", "بناصر بن شهرة", "سيدي مخلوف", "حاسي الدلاعة",
                "حاسي الرمل", "عين ماضي", "تاجموت", "الخنق", "قلتة سيدي سعد", "أفلو",
                "العساكفة", "وادي مرة", "وادي امزي", "الغيشة", "حاج مشري", "سبقاق",
                "تاويالة", "تاجرونة", "كراكدة", "سيدي بوزيد", "الحويطة", "بريدة", "بناصر بن شهرة"
            ),

            "04 - أم البواقي" to listOf(
                "أم البواقي", "عين بيضاء", "عين مليلة", "بحير الشرقي", "الأميرية", "سيقوس",
                "البلالة", "عين بابوش", "بريش", "أولاد حملة", "ضلعة", "عين كرشة",
                "هنشير تومغاني", "الجازية", "عين الديس", "فكيرينة", "سوق نعمان", "زورق",
                "الفجوج بوغرارة السعودي", "أولاد الزواي", "بير شهداء", "قصر الصباحي", "وادي نيني",
                "مسكيانة", "عين فكرون", "رحبة", "عين زيتون", "كانروبرت", "أولاد قاسم"
            ),

            "05 - باتنة" to listOf(
                "باتنة", "غسيرة", "معافة", "مروانة", "سريانة", "منعة", "المعذر",
                "تازولت لمباز", "نقاوس", "قيقبة", "اينوغيسن", "عيون العصافير", "جرمة",
                "بيطام", "عبد القادر", "أريس", "كيمل", "تيلاطو", "عين جاسر", "أولاد سلام",
                "تيغرغار", "عين ياقوت", "فسديس", "سفيان", "رحبة", "تيغانمين", "لمسان",
                "قصر بلعزمة", "سقانة", "إشمول", "فم الطوب", "بني فوضة الحقانية",
                "وادي الماء", "تالخمت", "بوزينة", "شمورة", "وادي الشعبة", "تاكسلنت",
                "قصبات", "أولاد عوف", "بومقر", "باريكة", "جزار", "تكوت", "عين التوتة",
                "هيدوسة", "ثنية العابد", "وادي الطاقة", "أولاد سي سليمان", "زانة البيضاء",
                "مدوكال", "أولاد فاضل", "تيمقاد", "رأس العيون", "شير", "شمورة", "لازرو",
                "بومية", "بولحيلات", "غسيرة"
            ),

            "06 - بجاية" to listOf(
                "بجاية", "أميزور", "فرعون", "تاوريرت إيغيل", "شلاطة", "تاموقرة", "تيمزريت",
                "سوق الثنين", "مسيسنة", "تينبذار", "تيشي", "سمعون", "قنديرة", "تيفرة",
                "إغرام", "أملو", "إغيل علي", "فنايا إيل متن", "تودجة", "درقينة", "سيدي عياد",
                "أوكاس", "بني جليل", "أدكار", "أقبو", "صدوق", "تازمالت", "آيت رزين",
                "شميني", "سوق أوفلة", "تاسكريوت", "تيبان", "تالة حمزة", "برباشة", "بني كسيلة",
                "وادي الغير", "اغيل ناصر", "تامريجت", "تاغزوت", "آيت سماعيل", "بوخليفة",
                "تيزي نبربر", "بني معوش", "أكفادو", "لفلاي", "خراطة", "ذراع قايد",
                "تاموقرة", "بوحمزة", "بني مليكش", "سيدي عيش", "القصر", "ملبو",
                "بوجليل", "آيت ملوك", "آيت رزين"
            ),

            "07 - بسكرة" to listOf(
                "بسكرة", "سيدي عقبة", "شتمة", "فوغالة", "براريس", "زريبة الوادي", "سيدي خالد",
                "مشونش", "القنطرة", "عين الناقة", "زريبة الوادي", "الفيض", "جمورة",
                "طولقة", "ليوة", "ليشانة", "أولاد جلال", "بسباس", "الغروس", "مزيرعة",
                "بوشقرون", "الحوش", "عين الزعطوط", "الوطاية", "دوسن", "الشعيبة", "خنقة",
                "أولاد ساسي", "رأس الميعاد", "مشونش", "أوماش", "مليلي", "خوبانة", "أورلال"
            ),

            "08 - بشار" to listOf(
                "بشار", "قنادسة", "لهمر", "بني ونيف", "طبلبالة", "إيقلي", "مغول",
                "عبادلة", "كرزاز", "تيمودي", "أولاد خضير", "عرق فراج", "بوكايس",
                "مغول", "تامترت", "بني إخلف", "تاقدة", "الواتة", "بني عباس",
                "أولاد خضير", "قصابي", "تيمودي", "مريجة", "مشرعة هواري بومدين"
            ),

            "09 - البليدة" to listOf(
                "البليدة", "الشريعة", "بوفاريك", "الأربعاء", "وادي العلايق", "الشفة", "حمام ملوان",
                "بن خليل", "الصومعة", "موزاية", "العفرون", "الشبلي", "بوينان", "أولاد سلامة",
                "بوقرة", "قرواو", "عين الرمانة", "جبور", "زبوجة", "وادي العلايق",
                "سوحان", "الغريب", "عين الحمام", "أولاد يعيش", "الشفة", "وادي جر", "مفتاح"
            ),

            "10 - البويرة" to listOf(
                "البويرة", "عين بسام", "بير الغبالو", "برج عكريش", "الهاشمية", "عمر",
                "الشرفة", "القادرية", "الجعابية", "عين الحجر", "ديرة", "سحاريج", "سوق الخميس",
                "حيزر", "الأخضرية", "معلة", "الحسينية", "تاغزوت", "ريدان", "بشلول",
                "بوكرم", "أغبالو", "زبربر", "عين الترك", "دشمية", "عين اللالوي", "عين الحجر",
                "مشدالة", "سور الغزلان", "عين بسام", "الأسنام", "راوراوة", "قرومة",
                "العجيبة", "تاقديت", "آث منصور تاوريرت", "حجوط", "عين الترك", "الوامري",
                "المقراني", "عين اللالوي", "عين الحجر", "آيت لعزيز", "بودربالة", "الحكيمية"
            ),

            "11 - تمنراست" to listOf(
                "تمنراست", "أبالسة", "عين غار", "تين زواتين", "تازروك", "عين أمقل",
                "عين صالح", "تاژوت", "إدلس", "تين زواتين", "سيلت", "عين قزام", "إيفروان"
            ),

            "12 - تبسة" to listOf(
                "تبسة", "بير العاتر", "الشريعة", "ستة قنطيس", "العوينات", "لهويجبات",
                "صفصاف الوسرى", "حمامات", "نقرين", "بير مقدم", "الكاف", "فركان",
                "بوخضرة", "بكارية", "عين زرقة", "المريج", "بولحاف دير", "بجن",
                "المرابط", "قوريق", "بير ذهب", "أقلة ملحة", "عين زرقة", "ثليجان",
                "الأقلة", "الكويف", "مرسط", "الهويجبات"
            ),

            "13 - تلمسان" to listOf(
                "تلمسان", "شتوان", "الحناية", "مغنية", "الرمشي", "حمام بوغرارة", "أولاد ميمون",
                "عين تالوت", "الفحالة", "عين الغرابة", "أولاد رياح", "بوحلو", "سوق أهراس",
                "سيدي عبد الله", "السبع شيوخ", "بني مستر", "فلاوسن", "عزايل", "عين النحالة",
                "بني سميل", "الغزوات", "السواني", "الجبالة", "الغور", "وادي الأخضر", "عين فزة",
                "أولاد ميمون", "بني وارسوس", "السواحلية", "بني بوسعيد", "مرسى بن مهيدي",
                "ندرومة", "سيدي مجاهد", "بني سنوس", "تيانت", "باب العسة", "دار يغمراسن",
                "هنين", "تيانت", "سبدو", "بني بهدل", "سيدي جيلالي", "بن سكران",
                "عين الكبيرة", "سيدي سنوسي", "بني سميل", "تيرني بني هديل", "زناتة",
                "أولاد رياح", "أميور", "عين فزة"
            ),

            "14 - تيارت" to listOf(
                "تيارت", "عين بوشقيف", "عين الزاريت", "عين الذهب", "عين كرمس", "دحموني",
                "رحوية", "مهدية", "السوقر", "سيدي علي ملال", "عين الحديد", "سرغين",
                "بوقرة", "فايجة", "رشايقة", "ناضورة", "تاقدمت", "وادي الليلي", "مشرعة الصفاء",
                "حمادية", "الشحيمة", "تخمارت", "سيدي حسني", "سبعين", "توسنينة", "فرندة",
                "عين كرمس", "قصر الشلالة", "رشايقة", "زمالة الأمير عبد القادر", "مادنة",
                "السبت", "جبيلات الرصفاء", "سيدي عبد الغني", "قرطوفة", "ملاكو", "سيدي بختي",
                "الشحيمة", "مدريسة", "جيلالي بن عمار", "عين بوشقيف", "فايجة", "نعيمة",
                "مدروسة", "سيدي علي ملال", "مشرعة الصفاء", "الشحيمة"
            ),

            "15 - تيزي وزو" to listOf(
                "تيزي وزو", "عين الحمام", "أقبيل", "فريحة", "الصومعة", "مشطرس", "إردجن",
                "تيميزارت", "مقودة", "ذراع الميزان", "تيزي غنيف", "بونوح", "آيت شعفاء",
                "فريقات", "بني عيسى", "بني زمنزر", "إيفرحونن", "عزازقة", "إيلولة أومالو",
                "يقورن", "لربعة نات إيراثن", "تيزي راشد", "زكري", "واقنون", "عين زاوية",
                "مكيرة", "آيت يحيى", "تيرميطين", "أكرو", "يطافن", "بني زيكي", "ذراع بن خدة",
                "واضياس", "عزفون", "تيقزيرت", "آيت عقواشة", "واسيف", "مزرانة", "إيمسوحال",
                "تادمايت", "آيت بومهدي", "أبي يوسف", "بني دوالة", "إيلتن", "بوزقن",
                "آيت يحيى موسى", "سوق الثنين", "آيت خليلي", "سيدي نعمان", "إيبودرارن",
                "أغريب", "إيفليسن", "بوجيمة", "آيت أومالو", "تيزي نتلاتة", "بني أوقليس",
                "آيت تودرت", "آيت بوعدو", "عاصي يوسف", "آيت عيسى ميمون", "آيت بومهدي",
                "أكرو", "إيمسوحال", "آيت خليلي", "معاتقة", "آيت يحيى"
            ),

            "16 - الجزائر" to listOf(
                "الجزائر الوسطى", "باب الوادي", "بولوغين", "القصبة", "وادي قريش", "بير مراد رايس",
                "بيرخادم", "بوروبة", "البيار", "حسين داي", "القبة", "الأوكاليبتوس", "رايس حميدو",
                "باب الزوار", "براقي", "دار البيضاء", "الدويرة", "درارية", "الحراش", "المقارية",
                "وادي السمار", "الرويبة", "سيدي موسى", "عين طاية", "برج البحري", "برج الخيفان",
                "المرسى", "حمة بوزيان", "المحمدية", "رغاية", "السولة", "سطاوالي", "الزرالدة",
                "عين بنيان", "الشراقة", "دالي إبراهيم", "حمامات", "أولاد فايت", "سيدي عبد الله",
                "تسالة المرجة", "محالمة", "الرحمانية", "السويدانية", "الخرايسية", "مفتاح", "بني مراد",
                "بوينان", "الشبلي", "الأوكاليبتوس", "الهراوة", "أولاد الشبل", "السولة", "تسالة المرجة"
            ),

            "17 - الجلفة" to listOf(
                "الجلفة", "مجبارة", "القعدة", "حاسي بحبح", "عين الإبل", "عين وسارة",
                "بيرين", "البويرة لحدب", "الشارف", "دلدول", "دار الشيوخ", "الخميس", "الإدريسية",
                "دويس", "فيض البطمة", "قطارة", "حاسي العش", "مسعد", "مليليحة", "سد رحال",
                "سلمانة", "سيدي بايزيد", "سيدي لعجال", "تعضميت", "زعفران", "زكار", "عين معبد",
                "بنهار", "بن يعقوب", "حد الصحاري", "حاسي الفدول", "أم العظام", "سيدي بوزيد",
                "عين الشهداء", "الجديدة", "القرنيني", "حاسي الدلاعة"
            ),

            "18 - جيجل" to listOf(
                "جيجل", "العراقين", "العوانة", "زيامة منصورية", "الطاهير", "الأمير عبد القادر",
                "الشقفة", "الشحنة", "الميلية", "سيدي معروف", "سطارة", "العنصر", "جيجل",
                "كاوس", "الغبالة", "بوراوي بلهاديف", "جيملة", "سلمى بن زيادة", "بودرية بني يجيس",
                "خيري وادي عجول", "تكسانة", "جمعة بني حبيبي", "برج الطاهير", "أولاد يحيى خضروش",
                "أولاد رباح", "واجانة", "سيدي عبد العزيز", "زيامة منصورية"
            ),

            "19 - سطيف" to listOf(
                "سطيف", "عين الكبيرة", "عين السبت", "أولاد سيدي أحمد", "بيضة برج", "العلمة",
                "عين عزل", "مزلوق", "بني عزيز", "أولاد تبان", "الرصفة", "أولاد عدوان",
                "بلعة", "عين روى", "تيكستر", "رأس الوادي", "رقان", "تاشودة", "بوسلام",
                "الوريسية", "تاية", "عين لقراج", "آيت نوال مزادة", "قيجل", "عين ولمان",
                "سرج الغول", "هربيل", "الولجة", "تيزي نبشار", "صاليط", "عين عزل",
                "أفون", "بني شبانة", "أولاد سي أحمد", "بوطالب", "بازر صخرة", "حمام سخنة",
                "بير حدادة", "سيدي مسران", "العلمة", "جميلة", "بني فودة", "تاشودة",
                "عموشة", "عين لحجر", "بوقاعة", "درم", "تلة", "حمام قرقور", "آيت تيزي",
                "معوقلان", "قنزت", "تلايفاسن", "بيضة برج", "الوريسية", "الحامة",
                "معاوية", "عين أرنات", "عين عبسة", "دحامشة", "بابور", "وادي البارد",
                "أولاد صابور", "أولاد سيدي أحمد", "صالح باي", "عين عزل", "بير العرش", "بني عزيز"
            ),

            "20 - سعيدة" to listOf(
                "سعيدة", "دوي ثابت", "أولاد إبراهيم", "مولاي العربي", "يوب", "هونت",
                "سيدي عمار", "سيدي بوبكر", "الحساسنة", "معمورة", "سيدي يعقوب", "تيرسين",
                "عين الحجر", "أولاد خالد", "سيدي أحمد", "عين سلطان"
            ),

            "21 - سكيكدة" to listOf(
                "سكيكدة", "الحدائق", "عزابة", "جندل سعدي محمد", "عين الشرشار", "بكوش لخضر",
                "بن عزوز", "السبت", "أولاد عطية", "وادي الزهور", "زردزاس", "أولاد هباب",
                "سيدي مزغيش", "امجز الدشيش", "بني ولبان", "عين بوزيان", "رمضان جمال",
                "بين الويدان", "العروش", "صالح بوشعور", "قمالوس", "عين كشرة", "خناق ميمون",
                "حمادي كرومة", "الغدير", "البوشطاطة", "أم الطوب", "بني بشير", "كركرة",
                "أولاد عطية", "فلفلة", "الشرايع", "بيضة", "مسعودان", "بني زيد", "زردزاس",
                "القل", "الزيتونة", "عين الزويت", "قنواع", "المرسى", "بن عزوز"
            ),

            "22 - سيدي بلعباس" to listOf(
                "سيدي بلعباس", "تسالة", "صفيصاف", "عين الثريد", "مرين", "رأس الماء", "سارنو",
                "عين تندامين", "حاسي الزهانة", "تلموني", "سيدي الحسن", "عين قادة", "مولاي سليسن",
                "يوب", "تسالة", "تلاغ", "سيدي حمادوش", "مصطفى بن براهيم", "سيدي خالد",
                "عين البرد", "تمايوت", "بن عاشبة شليا", "ضاية", "زهانة", "اوريحة الغابة",
                "سيدي براهيم", "مصطفى بن براهيم", "سيدي يعقوب", "لمطار", "واد صفيون",
                "عين تندامين", "عين الثريد", "بلعربي", "بن باديس", "بوخنافس", "شيطوان بلايلة",
                "الحصيبة", "حاسي الداهو", "حاسي الزهانة", "مقدرة", "مرحوم", "مسيد", "مرين",
                "مزاورو", "مصطفى بن براهيم", "مولاي سليسن", "واد السبع", "واد صفيون",
                "رأس الماء", "رجم دموش", "سهالة الثورة", "صفيصاف", "سيدي علي بن يوب",
                "سيدي علي بوصيدي", "سيدي براهيم", "سيدي شايب", "سيدي الداهو دشارة", "سيدي حمادوش",
                "سيدي خالد", "سيدي الحسن", "سيدي يعقوب", "الطابية", "تمايوت", "تلاغ",
                "تنيرة", "تسالة", "تلموني", "زرولة"
            ),

            "23 - عنابة" to listOf(
                "عنابة", "الحجار", "عين بردة", "البوني", "سيدي عمار", "الشرفة", "تريات",
                "عين البردة", "العلمة", "برحال", "الشطايبي", "واد العنب", "سرايدي",
                "الشرفة"
            ),

            "24 - قالمة" to listOf(
                "قالمة", "بوشقوف", "نشماية", "ركنية", "رأس العقبة", "برج الصباط",
                "بلخير", "الخزارة", "حمام دباغ", "واد الزناتي", "تملوكة", "الدهوارة",
                "هيليوبوليس", "حمام النبايل", "عين صندل", "مجاز عمار", "بومهرة أحمد",
                "الخزارة", "قلعة بوصبع", "مجاز الصفا", "عين مخلوف", "هواري بومدين",
                "عين العربي", "فج مزالة", "ركنية", "واد فراغة", "بني مزلين", "بن جراح",
                "برج الصباط", "عين حساينية", "سلاوة عنونة", "عين بن بايدة"
            ),

            "25 - قسنطينة" to listOf(
                "قسنطينة", "الخروب", "حامة بوزيان", "ابن زياد", "ديدوش مراد", "زيغود يوسف",
                "عين عبيد", "عين السمارة", "بني حامدن", "أولاد رحمون", "ابن باديس", "مسعود بوجريو",
                "عين الباي", "عين كرمة", "أولاد رحمون", "المريج", "بني حامدن", "عين السمارة"
            ),

            "26 - المدية" to listOf(
                "المدية", "وزرة", "عين بوسيف", "العمري", "سي المحجوب", "درراق", "العزيزية",
                "دامية", "بوغزول", "شلالة العذاورة", "بير بن عبد", "الوينات",
                "ميهوب", "مغراوة", "بعطة", "تمسقيدة", "خميس جمعة", "الصواقي",
                "بني سليمان", "جليدة", "الحوضين", "بوغار", "تفراوت", "الشنيقل",
                "عين اقصير", "عزيز", "واد حربيل", "تابلاط", "قلب الكبير", "بوسكن",
                "الحمدانية", "بن شيكاو", "الزوبيرية", "فيض حماد", "صانق", "سيدي دمد",
                "سيدي نعمان", "قصر البخاري", "قلب الكبير", "عين اقصير", "بوشراحيل",
                "حناشة", "زمورة", "أم الجليل", "أولاد عنتر", "سيدي الزاهر", "تيزي المهدي",
                "الشهبونة", "ثلاثة دوار", "مزغانة", "شلالة العذاورة", "دراع الصمار",
                "الربعية", "السدراية", "سيدي زيان", "عين بوسيف", "أولاد براهيم", "أولاد هلال",
                "البرواقية", "سغوان", "سيدي نعمان", "بن شيكاو", "العزيزية", "أولاد دايد",
                "عين بورك", "مجبار", "سيدي ربيع", "العمارية", "أولاد ميمون"
            ),

            "27 - مستغانم" to listOf(
                "مستغانم", "سيادة", "فرناكة", "ستيدية", "عين النويصي", "حاسي ماماش", "عين تادلس",
                "الصور", "أولاد معلاه", "سيدي علي", "عبد المالك رمضان", "عين بودينار", "تازقايط",
                "سيدي بلعطار", "المطمر", "منصورة", "السوافلية", "بوقيرات", "سيرات", "عين سيدي الشريف",
                "مسرة", "مازغران", "بن عبد المالك رمضان", "خير الدين", "سيدي لخضر", "طواهرية",
                "نكمارية", "الصافي", "الخضرة", "أولاد بوغالم", "حجاج", "واد الخير", "ستيدية",
                "عشعاشة"
            ),

            "28 - المسيلة" to listOf(
                "المسيلة", "المقرة", "حمام الضلعة", "أولاد دراج", "تارمونت", "معارف", "أولاد أنوقة",
                "سيدي عيسى", "برهوم", "بوسعادة", "أولاد سيدي براهيم", "سيدي عامر", "تامسة",
                "بن سرور", "محمد بوضياف", "أولاد عدي القبالة", "بلعايبة", "سيدي هجرس",
                "جبل مساعد", "حمام الضلعة", "عين الحجل", "زرزور", "خوبانة", "مشونش",
                "بن زوه", "أولاد سليمان", "الحوامد", "عين الملح", "أولاد منصور", "المعاضيد",
                "الصوامع", "عين فارس", "الشلال", "الخطوطي سيد الجير", "سليم", "الدهاهنة",
                "بوطي السايح", "بير فودة", "سيدي عيسى", "مجدل", "أولاد مادهي", "بن عيسى",
                "أولاد سيدي براهيم", "عين خضرة", "منعة", "حمام الضلعة", "أولاد دراج"
            ),

            "29 - معسكر" to listOf(
                "معسكر", "بوحنيفة", "تيغنيف", "واد الأبطال", "عين فارس", "سيق", "المأمونية",
                "عوف", "العلايمة", "البرج", "رأس عين عميروش", "خلوية", "المنور",
                "سيدي قادة", "زلامطة", "واد تاغية", "سيدي عبد المؤمن", "فراقيق", "القعدة",
                "الشرفة", "هاشم", "المحمدية", "سيدي عبد الجبار", "نسموث", "عين فكان",
                "قرجوم", "الهاشم", "سحايلية", "فروحة", "ماطمور", "مقدة", "عقاز",
                "بنيان", "سدجرارة", "مخدة", "غريس", "ماوسة", "بو هني", "القورط",
                "واد الأبطال", "رأس عين عميروش", "سيدي عبد المؤمن", "تيزي"
            ),

            "30 - ورقلة" to listOf(
                "ورقلة", "انقوسة", "حاسي مسعود", "الرويسات", "عين بيضة", "سيدي خويلد",
                "حاسي بن عبد الله", "تماسين", "تقرت", "النزلة", "الزاوية العابدية", "العالية",
                "بليدة عمور", "الطيبات", "بن ناصر", "البرمة", "حاسي القارة", "سيدي سليمان",
                "الحجيرة", "المقارين", "الجامعة", "أم الطيور", "ستيل", "المنقار", "حاسي مسعود"
            ),

            "31 - وهران" to listOf(
                "وهران", "بير الجير", "حاسي بونيف", "السانية", "أرزيو", "بيطيوة", "المرسى الكبير",
                "عين الترك", "بوسفر", "الأنصار", "واد ثلاث", "طفراوي", "سيدي الشامي", "مسرغين",
                "بوتليليس", "عين كرمة", "بن فريحة", "حاسي بن عكبة", "حاسي مفسوخ", "سيدي بن يبقى",
                "البراية", "قديل", "عين البية", "مرسى الحجاج", "عين كرمة", "بوفاطيس", "حاسي بونيف"
            ),

            "32 - البيض" to listOf(
                "البيض", "رقاصة", "ستيتن", "بريزينة", "الغاسول", "بوقطب", "الخيثر",
                "كاف الأحمر", "بوعلام", "عين الورك", "أربوات", "بريدة", "الشقيق", "المحارة",
                "توسمولين", "سيدي عمار", "سيدي سليمان", "سيدي الطيفور", "كراكدة", "الشلالة",
                "العبيوض سيدي الشيخ", "عين وركة"
            ),

            "33 - إليزي" to listOf(
                "إليزي", "جانت", "برج عمر إدريس", "دب داب", "عين أميناس"
            ),

            "34 - برج بوعريريج" to listOf(
                "برج بوعريريج", "رأس الواد", "برج زموري", "منصورة", "مجانة", "ثنية النصر",
                "الجعافرة", "الحمادية", "عين تغروت", "برج غدير", "سيدي أمبارك", "أولاد براهيم",
                "أولاد دحمان", "حرازة", "المهير", "بن داود", "العاشر", "عين تسرة", "بير قاصد علي",
                "العوش", "الغيلاسة", "الرابطة", "بليمور", "الجعافرة", "القصور", "أولاد سيدي براهيم",
                "تيكستر", "كولا", "تقلعيت", "القصور", "أولاد دحمان", "تسامرت", "أولاد سيدي براهيم"
            ),

            "35 - بومرداس" to listOf(
                "بومرداس", "الناصرية", "جنات", "يسر", "زموري", "سي مصطفى", "تيجلابين",
                "شعبة العامر", "ثنية", "تيمزريت", "قورصو", "أولاد موسى", "لارباتاش",
                "بودواو", "عفير", "برج منايل", "بغلية", "سيدي داود", "نتيجة", "الخميستي",
                "حمادي", "أولاد عيسى", "بن شود", "دلس", "عمال", "بني عمران", "سوق الحد",
                "بوزقزة قدارة", "تاورقة", "أولاد هداج", "لقاطة", "بني عمران", "الخروبة",
                "يسرس"
            ),

            "36 - الطارف" to listOf(
                "الطارف", "بوحجار", "بن مهيدي", "البوثلجة", "العيون", "الصوارخ", "بريحان",
                "بحيرة الطيور", "الشفية", "الدرعان", "الشيحاني", "حمام بني صالح", "رمل السوق",
                "عين العسل", "الشط", "الزيتونة", "واد الزيتون", "بسباس", "العصفور", "الشط"
            ),

            "37 - تندوف" to listOf(
                "تندوف", "أم العسل"
            ),

            "38 - تيسمسيلت" to listOf(
                "تيسمسيلت", "برج بونعامة", "ثنية الحد", "الأزهرية", "بني شايب", "لرجام",
                "مليعاب", "سيدي لعنتري", "برج الأمير عبد القادر", "الأيون", "الخميستي", "أولاد بسام",
                "العماري", "اليوسفية", "سيدي بوتوشنت", "العربعة", "المعاصم", "سيدي عابد", "تمالحت",
                "بوقايد", "بني لحسن", "أولاد بسام", "سيدي سليمان"
            ),

            "39 - الوادي" to listOf(
                "الوادي", "الروبة", "واد العلندة", "البياضة", "النخلة", "قمار", "الكوينين",
                "الرقيبة", "الحمراية", "تغزوت", "الدبيلة", "حساني عبد الكريم", "حاسي خليفة",
                "الطريفاوي", "المقرن", "الجامعة", "أم الطيور", "سيدي عون", "تامرلاغت", "الطندلة",
                "العقلة", "ميه ونسة", "بن قشة", "أورمس", "ستيل", "طالب العربي"
            ),

            "40 - خنشلة" to listOf(
                "خنشلة", "متوسة", "قايس", "باغاي", "الحامة", "عين الطويلة", "تاوزيانات",
                "بوحمامة", "الولجة", "الرميلة", "الشرشار", "جلال", "بابار", "تامسة", "النسيقة",
                "أولاد رشاش", "المحمل", "مسارة", "يابوس", "خيران", "الشلية"
            ),

            "41 - سوق أهراس" to listOf(
                "سوق أهراس", "سدراتة", "الحنانشة", "المشروحة", "أولاد إدريس", "الطفاح", "الزعرورية",
                "الطاوورة", "الضرعة", "الهدادة", "عين سلطان", "عين زانة", "أولاد مؤمن", "بير بوحوش",
                "صافل الويدان", "راقوبة نعام", "خميسة", "أم العظايم", "عين كرشة", "تيراقلت",
                "اللهاب", "مراحنا", "سيدي فرج", "مداوروش", "ويلن"
            ),

            "42 - تيبازة" to listOf(
                "تيبازة", "منصور", "الرحاط", "الدواودة", "بوركيكة", "الخميستي", "آغا بولكريم",
                "الحطاطبة", "سيدي عمار", "الشايبة", "عين تقوريت", "شرشال", "دموس", "مراد",
                "فوكة", "بو اسماعيل", "أحمر العين", "بوهارون", "سيدي غيلس", "مسلمون",
                "سيدي راشد", "القليعة", "العطاطبة", "سيدي سمعان", "بو هارون", "حجرة النوص",
                "قورية"
            ),

            "43 - ميلة" to listOf(
                "ميلة", "فرجيوة", "شلغوم العيد", "واد أثمنية", "عين مليوك", "تالرغمة",
                "واد سقان", "تجانت", "بن يحيى عبد الرحمن", "عين الطين", "المشيرة",
                "واد العنجة", "عين بيضة هريش", "منار زرزة", "عميرة عرس", "تسالة لمطاعي",
                "قرارم قوقة", "الحمالة", "رواشد", "أحمد راشدي", "الشقارة", "نشماية",
                "درادجي بوسلاح", "سيدي مروان", "تيبرقنت", "بوحاتم", "الزغاية",
                "العيادي بربس", "سيدي خليفة", "يحيى بنيقشة", "أولاد خلوف", "تراي باينان"
            ),

            "44 - عين الدفلى" to listOf(
                "عين الدفلى", "خميس مليانة", "الروينة", "عريب", "جليدة", "العمرة", "برباش",
                "جندل", "واد الشرفة", "عين بويحيى", "الكريمية", "واد الفضة", "مليانة", "بن علال",
                "بير ولد خليفة", "بورعشد", "خميس مليانة", "حمام ريغة", "عريب", "عين التركي",
                "سيدي لخضر", "الحسينية", "تاشتة زوقاغة", "عين بنيان", "الزدين", "واد الجمعة",
                "الباطة", "تيبركانين", "بلعاس", "بن علال", "عين سلطان", "بورعشد", "المنية",
                "المخاطرية", "عين بويحيى", "الزدين"
            ),

            "45 - النعامة" to listOf(
                "النعامة", "مشرية", "عين الصفراء", "التيوت", "الصفيصيفة", "مغرار", "عسلة", "جنيان بورزق",
                "عين بن خليل", "مكمن بن عامر", "القصدير", "البيود"
            ),

            "46 - عين تموشنت" to listOf(
                "عين تموشنت", "حمام بوحجر", "عين طولبة", "التارقة", "عين كيحل", "سيدي بن عدة",
                "أوبليل", "الأغلال", "بني صاف", "سيدي صافي", "ولهاصة الغرابة", "تمزورة", "الشنتوف",
                "سيدي بومدين", "واد بركش", "عين العربعة", "المالح", "شعبة اللحم",
                "سيدي اوريش", "المسيردة فوقة", "حاسي الغلة", "حاسي الداهي", "العامرية", "الأمير عبد القادر",
                "واد الصباح", "أولاد بوجمعة", "عين العربعة"
            ),

            "47 - غرداية" to listOf(
                "غرداية", "المنيعة", "ضاية بن ضحوة", "بريان", "متليلي", "العطوف", "أولاد شانب",
                "منصورة", "حاسي الفحل", "حاسي القارة", "زلفانة", "سبسب", "بونورة"
            ),

            "48 - غليزان" to listOf(
                "غليزان", "واد الرهيو", "بلعباس", "سيدي سعادة", "أولاد عيسى", "سيدي لزرق",
                "الحمادنة", "مازونة", "القلعة", "عين رحمة", "يلل", "واد السلام", "وريزان",
                "لحلف", "بني درقن", "سيدي محمد بن عودة", "حاسي ماماش", "المديونة",
                "سيدي الخطاب", "عمي موسى", "زمورة", "بني زنتيس", "سوق الحد", "الجيديوية",
                "القطار", "الحمري", "المطمر", "رمكة", "منداس", "سيدي محمد بن علي", "عين تارك",
                "واد الجمعة", "مرجة سيدي عابد", "أولاد سيدي ميهوب", "بني درقن", "الولجة",
                "سيدي سعادة", "دار بن عبد الله", "بن داود"
            ),

            "49 - تيميمون" to listOf(
                "تيميمون", "أولاد عيسى", "أولاد سعيد", "تينركوك", "دلدول", "متارفة", "تالمين"
            ),

            "50 - برج باجي مختار" to listOf(
                "برج باجي مختار", "تيمياوين", "تين زواتين"
            ),

            "51 - أولاد جلال" to listOf(
                "أولاد جلال", "سيدي خالد", "بسباس", "الشايبة", "دوسن", "رأس الميعاد"
            ),

            "52 - بني عباس" to listOf(
                "بني عباس", "تابلبالة", "إيقلي", "أولاد خودير", "تامطرت", "تيمودي", "الواطة",
                "كرزاز", "القصابي"
            ),


            "53 - عين صالح" to listOf(
                "عين صالح", "فقارة الزاوية", "عين غار"
            ),

            "54 - عين قزام" to listOf(
                "عين قزام", "تين زواتين"
            ),

            "55 - تقرت" to listOf(
                "تقرت", "تبسبست", "النزلة", "العالية", "تماسين", "بليدة عمور", "الطيبات",
                "المقارين", "المنقار", "سيدي سليمان", "الزاوية العابدية"
            ),

            "56 - جانت" to listOf(
                "جانت", "برج الحواس"
            ),

            "57 - المغير" to listOf(
                "المغير", "الجامعة", "أم الطيور", "سيدي عون", "أورمس", "ستيل"
            ),

            "58 - المنيعة" to listOf(
                "المنيعة", "حاسي القارة", "حاسي الفحل"
            )


        )



        val PropertyTypeName = listOf("للبيع","للكراء","للتبادل")
        val PropertyName = arrayOf("شقة", "بيت طابق", "كوخ", "مجمع سياحي", "مرقد", "دوبلكس", "محل تجاري", "فيلا", "قاعة حفلات", "ستوديو", "أرض", "أرض فلاحية", "عمارة", "بالڨالو", "مستودع - مصنع", "آخر")
        val PaymentTypeName = listOf("بالتقسيط","الائتمان البنكي","وعد بالبيع","نقداً")
        val DocumentIdsName = listOf("سند الملكية","رخصة البناء","رخصة السكن","مخطط المسح","شهادة الضرائب","فواتير المرافق")
        val FeatureIdsName = listOf("مسبح","كراج","حديقة","مصعد","تكييف","تدفئة مركزية","نظام أمني","مفروش","موقف سيارات","قبو")

    }


    // Property Type Constants
    object PropertyType {
        const val SALE = 1      // بيع
        const val RENT = 2      // كراء
        const val EXCHANGE = 3  // تبادل
    }

    // Payment Type Constants
    object PaymentType {
        const val INSTALLMENT = 1    // بالتقسيط
        const val BANK_CREDIT = 2    // الائتمان البنكي
        const val PROMISE_SALE = 3   // وعد بالبيع
        const val CASH = 4           // نقداً
    }


    // Document Type Constants (Example - adjust based on your document types)
    object DocumentIds {
        const val PROPERTY_DEED = 1      // سند الملكية
        const val BUILDING_PERMIT = 2    // رخصة البناء
        const val OCCUPANCY_PERMIT = 3   // رخصة السكن
        const val SURVEY_PLAN = 4        // مخطط المسح
        const val TAX_CERTIFICATE = 5    // شهادة الضرائب
        const val UTILITY_BILLS = 6      // فواتير المرافق
    }

    // Property Feature Constants (Example - adjust based on your features)
    object FeatureIds {
        const val SWIMMING_POOL = 1      // مسبح
        const val GARAGE = 2             // كراج
        const val GARDEN = 3             // حديقة
        const val ELEVATOR = 4           // مصعد
        const val AIR_CONDITIONING = 5   // تكييف
        const val CENTRAL_HEATING = 6    // تدفئة مركزية
        const val SECURITY_SYSTEM = 7    // نظام أمني
        const val FURNISHED = 8          // مفروش
        const val PARKING = 9           // موقف سيارات
        const val BASEMENT = 10          // قبو
    }

    // Wilaya (Province) Constants - All 58 Algerian Wilayas
    object WilayaIds {
        const val ADRAR = 1                     // أدرار
        const val CHLEF = 2                     // الشلف
        const val LAGHOUAT = 3                  // الأغواط
        const val OUM_EL_BOUAGHI = 4            // أم البواقي
        const val BATNA = 5                     // باتنة
        const val BEJAIA = 6                    // بجاية
        const val BISKRA = 7                    // بسكرة
        const val BECHAR = 8                    // بشار
        const val BLIDA = 9                     // البليدة
        const val BOUIRA = 10                   // البويرة
        const val TAMANRASSET = 11              // تمنراست
        const val TEBESSA = 12                  // تبسة
        const val TLEMCEN = 13                  // تلمسان
        const val TIARET = 14                   // تيارت
        const val TIZI_OUZOU = 15               // تيزي وزو
        const val ALGIERS = 16                  // الجزائر
        const val DJELFA = 17                   // الجلفة
        const val JIJEL = 18                    // جيجل
        const val SETIF = 19                    // سطيف
        const val SAIDA = 20                    // سعيدة
        const val SKIKDA = 21                   // سكيكدة
        const val SIDI_BEL_ABBES = 22           // سيدي بلعباس
        const val ANNABA = 23                   // عنابة
        const val GUELMA = 24                   // قالمة
        const val CONSTANTINE = 25              // قسنطينة
        const val MEDEA = 26                    // المدية
        const val MOSTAGANEM = 27               // مستغانم
        const val MSILA = 28                    // المسيلة
        const val MASCARA = 29                  // معسكر
        const val OUARGLA = 30                  // ورقلة
        const val ORAN = 31                     // وهران
        const val EL_BAYADH = 32                // البيض
        const val ILLIZI = 33                   // إليزي
        const val BORDJ_BOU_ARRERIDJ = 34       // برج بوعريريج
        const val BOUMERDES = 35                // بومرداس
        const val EL_TARF = 36                  // الطارف
        const val TINDOUF = 37                  // تندوف
        const val TISSEMSILT = 38               // تيسمسيلت
        const val EL_OUED = 39                  // الوادي
        const val KHENCHELA = 40                // خنشلة
        const val SOUK_AHRAS = 41               // سوق أهراس
        const val TIPAZA = 42                   // تيبازة
        const val MILA = 43                     // ميلة
        const val AIN_DEFLA = 44                // عين الدفلى
        const val NAAMA = 45                    // النعامة
        const val AIN_TEMOUCHENT = 46           // عين تموشنت
        const val GHARDAIA = 47                 // غرداية
        const val RELIZANE = 48                 // غليزان
        const val TIMIMOUN = 49                 // تيميمون
        const val BORDJ_BADJI_MOKHTAR = 50      // برج باجي مختار
        const val OULED_DJELLAL = 51            // أولاد جلال
        const val BENI_ABBES = 52               // بني عباس
        const val IN_SALAH = 53                 // عين صالح
        const val IN_GUEZZAM = 54               // عين قزام
        const val TOUGGOURT = 55                // تقرت
        const val DJANET = 56                   // جانت
        const val EL_MGHAIR = 57                // المغير
        const val EL_MENIAA = 58                // المنيعة
    }

    // Municipality (Commune) Constants - All Algerian Municipalities
    object MunicipalityIds {

        // 01 - Wilaya d'Adrar (8 Communes)
        const val ADRAR = 101
        const val TAMANTIT = 102
        const val BOUDA = 103
        const val REGGANE = 104
        const val IN_ZGHMIR = 105
        const val TIT = 106
        const val TSABIT = 107
        const val ZAOUIET_KOUNTA = 108

        // 02 - Wilaya de Chlef (35 Communes)
        const val CHLEF = 201
        const val TENES = 202
        const val BENAIRIA = 203
        const val EL_KARIMIA = 204
        const val TADJENA = 205
        const val TAOUGRIT = 206
        const val BENI_HAOUA = 207
        const val SOBHA = 208
        const val HARCHOUN = 209
        const val OULED_FARES = 210
        const val SIDI_AKKACHA = 211
        const val BOUKADIR = 212
        const val BENI_RACHED = 213
        const val TALASSA = 214
        const val HERENFA = 215
        const val OUED_GOUSSINE = 216
        const val DAHRA = 217
        const val OULED_ABBES = 218
        const val SENDJAS = 219
        const val ZEBOUDJA = 220
        const val OUED_SLY = 221
        const val ABOU_EL_HASSAN = 222
        const val EL_MARSA = 223
        const val CHETTIA = 224
        const val SIDI_ABDERRAHMANE = 225
        const val MOUSSADEK = 226
        const val EL_HADJADJ = 227
        const val LABIOD_MEDJADJA = 228
        const val OUED_FODDA = 229
        const val OULED_BEN_ABDELKADER = 230
        const val BOUZGHAIA = 231
        const val AIN_MERANE = 232
        const val OUM_DROU = 233
        const val BREIRA = 234
        const val BENI_BOUATEB = 235

        // 03 - Wilaya de Laghouat (24 Communes)
        const val LAGHOUAT = 301
        const val KSAR_EL_HIRANE = 302
        const val BENNASSER_BENCHOHRA = 303
        const val SIDI_MAKHLOUF = 304
        const val HASSI_DELAA = 305
        const val HASSI_RMEL = 306
        const val AIN_MADHI = 307
        const val TADJMOUT = 308
        const val KHENEG = 309
        const val GUELTAT_SIDI_SAAD = 310
        const val AIN_SIDI_ALI = 311
        const val EL_BEIDHA = 312
        const val BRIDA = 313
        const val EL_GHICHA = 314
        const val HADJ_MECHRI = 315
        const val SEBGAG = 316
        const val TAOUIALA = 317
        const val TADJROUNA = 318
        const val AFLOU = 319
        const val EL_ASSAFIA = 320
        const val OUED_MORRA = 321
        const val OUED_MZI = 322
        const val EL_HAOUAITA = 323
        const val SIDI_BOUZID = 324

        // 04 - Wilaya d'Oum El Bouaghi (29 Communes)
        const val OUM_EL_BOUAGHI = 401
        const val AIN_BEIDA = 402
        const val AIN_MLILA = 403
        const val BEHIR_CHERGUI = 404
        const val EL_AMIRIA = 405
        const val SIGUS = 406
        const val EL_BELALA = 407
        const val AIN_BABOUCHE = 408
        const val BERRICHE = 409
        const val OULED_HAMLA = 410
        const val DHALAA = 411
        const val AIN_KERCHA = 412
        const val HANCHIR_TOUMGHANI = 413
        const val EL_DJAZIA = 414
        const val AIN_DISS = 415
        const val FKIRINA = 416
        const val SOUK_NAAMANE = 417
        const val ZORG = 418
        const val EL_FEDJOUDJ_BOUGHRARA_SAOUDI = 419
        const val OULED_ZOUAI = 420
        const val BOUGHRARA_SAOUDI = 421
        const val KSAR_SBAHI = 422
        const val OUED_NINI = 423
        const val MESKIANA = 424
        const val RAHIA = 425
        const val AIN_FEKROUN = 426
        const val EL_HARMILIA = 427
        const val OULED_GACEM = 428
        const val OULED_MOUSSA = 429

        // 05 - Wilaya de Batna (61 Communes)
        const val BATNA = 501
        const val GHASSIRA = 502
        const val MAAFA = 503
        const val MEROUANA = 504
        const val SERIANA = 505
        const val MENAA = 506
        const val EL_MADHER = 507
        const val TAZOULT = 508
        const val NGAOUS = 509
        const val GUIGBA = 510
        const val INOUGHISSEN = 511
        const val OUYAYOUN_EL_ASSAFIR = 512
        const val DJERMA = 513
        const val OUED_CHAABA = 514
        const val TIGHARGHAR = 515
        const val AIN_YAGOUT = 516
        const val FESDIS = 517
        const val SEFIANE = 518
        const val RAHBAT = 519
        const val TIGHANIMINE = 520
        const val LEMSANE = 521
        const val KSAR_BELLEZMA = 522
        const val SEGGANA = 523
        const val ICHMOUL = 524
        const val FOUM_TOUB = 525
        const val BENI_FOUDHALA_EL_HAKANIA = 526
        const val OUED_EL_MA = 527
        const val TALKHEMPT = 528
        const val RAS_EL_AIOUN = 529
        const val CHIR = 530
        const val TENIET_EL_ABED = 531
        const val OUED_TAGA = 532
        const val ARRIS = 533
        const val KIMMEL = 534
        const val TIMGAD = 535
        const val BOUMAGUEUR = 536
        const val BARIKA = 537
        const val DJEZZAR = 538
        const val TKOUT = 539
        const val AIN_DJASSER = 540
        const val OULED_SALLAM = 541
        const val LARBAA_BATNA = 542
        const val BOUZINA = 543
        const val CHEMORA = 544
        const val BOULHILET = 545
        const val ZANAT_EL_BEIDA = 546
        const val OULED_FADEL = 547
        const val OULED_SI_SLIMANE = 548
        const val TAXLENT = 549
        const val GOSBAT = 550
        const val OULED_AOUF = 551
        const val BITAM = 552
        const val MDOUKAL = 553
        const val OULED_AMMAR = 554
        const val EL_HASSI = 555
        const val LAZROU = 556
        const val HIDOUSSA = 557
        const val KAIS = 558
        const val TILATOU = 559
        const val BOUMIA = 560
        const val DHAR_EL_AKHDARI = 561

        // 06 - Wilaya de Béjaïa (52 Communes)
        const val BEJAIA = 601
        const val AMIZOUR = 602
        const val FERRAOUN = 603
        const val TAOURIRT_IGHIL = 604
        const val CHELLATA = 605
        const val TAMRIDJET = 606
        const val TIMEZRIT = 607
        const val SOUK_EL_TENINE = 608
        const val MCISNA = 609
        const val TINEBDAR = 610
        const val TICHY = 611
        const val AOKAS = 612
        const val BENI_DJELLIL = 613
        const val AIT_R_ZINE = 614
        const val IGHRAM = 615
        const val AMALOU = 616
        const val IGHIL_ALI = 617
        const val IFELAIN_ILMATEN = 618
        const val TOUDJA = 619
        const val DARGUINA = 620
        const val SIDI_AYAD = 621
        const val AIT_SMAIL = 622
        const val KHERRATA = 623
        const val DRA_EL_KAID = 624
        const val KENDIRA = 625
        const val TIZI_N_BERBER = 626
        const val BENI_KSILA = 627
        const val SOUK_OUFELLA = 628
        const val TASKRIOUT = 629
        const val TIBANE = 630
        const val AKBOU = 631
        const val SEDDOUK = 632
        const val TAZMALT = 633
        const val AIT_MELLIKECHE = 634
        const val CHEMINI = 635
        const val BOUKHELIFA = 636
        const val TAMORA = 637
        const val ADEKAR = 638
        const val AKFADOU = 639
        const val LEFLAYE = 640
        const val OUZELLAGUEN = 641
        const val BOUHAMZA = 642
        const val BENI_MAOUCHE = 643
        const val SIDI_AICH = 644
        const val EL_KSEUR = 645
        const val MELBOU = 646
        const val TALA_HAMZA = 647
        const val BARBACHA = 648
        const val BENI_MALIKECHE = 649
        const val OUED_GHIR = 650
        const val BOUDJELIL = 651
        const val FENAIA_IL_MATEN = 652

        // 07 - Wilaya de Biskra (27 Communes)
        const val BISKRA = 701
        const val EL_HADJAB = 702
        const val EL_OUTAYA = 703
        const val DJEMORAH = 704
        const val BRANIS = 705
        const val AIN_NAGA = 706
        const val TOLGA = 707
        const val LICHANA = 708
        const val FOUGHALA = 709
        const val BORDJ_BEN_AZZOUZ = 710
        const val MEZIRAA = 711
        const val BOKHROU = 712
        const val SIDI_OKBA = 713
        const val CHETMA = 714
        const val EL_GHROUS = 715
        const val EL_HAOUCH = 716
        const val MECHOUNECHE = 717
        const val AIN_ZAATOUT = 718
        const val ZERIBET_EL_OUED = 719
        const val KHENGUET_SIDI_NADJI = 720
        const val OURLAL = 721
        const val MLILI = 722
        const val EL_FEIDH = 723
        const val BOUCHAGROUN = 724
        const val OUMACHE = 725
        const val LIoua = 726
        const val MZERRAA = 727

        // 08 - Wilaya de Béchar (11 Communes)
        const val BECHAR = 801
        const val ERG_FERRADJ = 802
        const val OUED_DE_CHAABA = 803
        const val MOGHEUL = 804
        const val LAHMAR = 805
        const val BOUKAIS = 806
        const val KENADSA = 807
        const val ABADLA = 808
        const val MECHRAA_HOUMADI = 809
        const val BENI_OUNIF = 810
        const val TAGHIT = 811

        // 09 - Wilaya de Blida (25 Communes)
        const val BLIDA = 901
        const val CHEBLI = 902
        const val BOUINAN = 903
        const val OUED_ALLEUG = 904
        const val OULED_YAICH = 905
        const val CHREA = 906
        const val EL_AFFROUN = 907
        const val CHIFFA = 908
        const val HAMMAM_MELOUANE = 909
        const val BEN_KHELIL = 910
        const val SOUMAA = 911
        const val MOUZAIA = 912
        const val AIN_ROMANA = 913
        const val LARBAA_BLIDA = 914
        const val SOUHANE = 915
        const val MEFTAH = 916
        const val OULED_SLAMA = 917
        const val BOUFARIK = 918
        const val GUERROUAOU = 919
        const val BENI_TAMOU = 920
        const val BOUARFA = 921
        const val BENI_MERED = 922
        const val DJEBABRA = 923
        const val BOUGARA = 924
        const val OUED_DJER = 925

        // 10 - Wilaya de Bouira (45 Communes)
        const val BOUIRA = 1001
        const val AIN_TURK = 1002
        const val AIT_LAAZIZ = 1003
        const val AGHBALOU = 1004
        const val DECHMIA = 1005
        const val HADJERA_ZERGA = 1006
        const val HAIZER = 1007
        const val TAGHZOUT = 1008
        const val EL_HAKIMIA = 1009
        const val EL_KHABOUZIA = 1010
        const val AIN_EL_HADJAR = 1011
        const val MAAMORA = 1012
        const val RIDANE = 1013
        const val SOUR_EL_GHOZLANE = 1014
        const val OULED_RACHED = 1015
        const val AIN_BESSEM = 1016
        const val HANIF = 1017
        const val MEZDOUR = 1018
        const val BECHLOUL = 1019
        const val BIR_GHBALOU = 1020
        const val BOUKRAM = 1021
        const val DIRAH = 1022
        const val EL_ADJIBA = 1023
        const val GUERROUMA = 1024
        const val KADIRIA = 1025
        const val LAKHDARIA = 1026
        const val MCHEDALLAH = 1027
        const val SAHARIDJ = 1028
        const val TAGUEDIT = 1029
        const val AOMAR = 1030
        const val CHORFA = 1031
        const val EL_ASNAM = 1032
        const val EL_MOKRANI = 1033
        const val OUED_EL_BERDI = 1034
        const val RAOURAOUA = 1035
        const val ZBARBAR = 1036
        const val AHL_EL_KSAR = 1037
        const val ATH_MANSOUR = 1038
        const val BORDJ_OKHRISS = 1039
        const val BOUAICHE = 1040
        const val DJEBAHIA = 1041
        const val EL_HACHIMIA = 1042
        const val HAKIMIA = 1043
        const val MAALA = 1044
        const val SOUK_EL_KHEMIS = 1045

        // 11 - Wilaya de Tamanrasset (5 Communes)
        const val TAMANRASSET = 1101
        const val Abalessa = 1102
        const val IDLES = 1103
        const val TAZROUK = 1104
        const val AIN_AMGUEL = 1105

        // 12 - Wilaya de Tébessa (28 Communes)
        const val TEBESSA = 1201
        const val CHERIA = 1202
        const val BIR_EL_ATER = 1203
        const val LAOUINET = 1204
        const val EL_AOUIDJA = 1205
        const val EL_OGLA = 1206
        const val SAFSAF_EL_OUESRA = 1207
        const val GUORRIGUER = 1208
        const val BIR_MOKKADEM = 1209
        const val BOUEKHADRA = 1210
        const val EL_KOUif = 1211
        const val MORSOTT = 1212
        const val NEGRINE = 1213
        const val OUED_KEBERIT = 1214
        const val OUM_ALI = 1215
        const val TELIDJENE = 1216
        const val AIN_ZERGA = 1217
        const val BEKKARIA = 1218
        const val BOULHAF_DYR = 1219
        const val EL_MA_LABIODH = 1220
        const val EL_MERIDJ = 1221
        const val EL_MEZRAA = 1222
        const val FERKANE = 1223
        const val GUESRA = 1224
        const val HADDADA = 1225
        const val OGASSA = 1226
        const val SIDI_SLIMANE = 1227
        const val STAH_GUENTIS = 1228

        // 13 - Wilaya de Tlemcen (53 Communes)
        const val TLEMCEN = 1301
        const val AIN_GHRABA = 1302
        const val AIN_FEZZA = 1303
        const val AIN_KEBIRA = 1304
        const val AIN_TALLOUT = 1305
        const val AIN_YOUCEF = 1306
        const val AMIEUR = 1307
        const val AZails = 1308
        const val BAB_EL_ASSA = 1309
        const val BENI_BAHDEL = 1310
        const val BENI_BOU_SAID = 1311
        const val BENI_MESTER = 1312
        const val BENI_OUARSAS = 1313
        const val BENI_SNOUS = 1314
        const val BENI_SMIEH = 1315
        const val BEN_SEKRANE = 1316
        const val BOUHLOU = 1317
        const val CHETOUANE = 1318
        const val DAR_YAGHMOURASSEN = 1319
        const val DJEBala = 1320
        const val EL_ARICHA = 1321
        const val EL_BOUHI = 1322
        const val EL_FEHOUl = 1323
        const val EL_GOR = 1324
        const val FELLAOUCENE = 1325
        const val GHAZAOUET = 1326
        const val HAMMAM_BOUGHRARA = 1327
        const val HENNAYA = 1328
        const val HONAINE = 1329
        const val MAGHNIA = 1330
        const val MANSOURAH = 1331
        const val MARSA_BEN_MHIDI = 1332
        const val MSIRDA_FOUAGA = 1333
        const val NEDROMA = 1334
        const val OUED_CHOUK = 1335
        const val OULED_MIMOUN = 1336
        const val OULED_RIYAH = 1337
        const val REMCHI = 1338
        const val SABRA = 1339
        const val SEBBAA_CHIOUKH = 1340
        const val SEBDOU = 1341
        const val SIDI_ABDALLI = 1342
        const val SIDI_DJILLALI = 1343
        const val SIDI_MEDJAHeD = 1344
        const val SOUAHLIA = 1345
        const val SOUANI = 1346
        const val SOUK_TLETA = 1347
        const val TERNATEN = 1348
        const val TIANET = 1349
        const val TIRENI = 1350
        const val Tounane = 1351
        const val ZAHRA = 1352
        const val ZENATA = 1353



        // 49 - Wilaya de Timimoun (10 Communes)
        const val TIMIMOUN_49 = 4901
        const val OULED_SAID = 4902
        const val AOULEF = 4903
        const val TINERKOUK = 4904
        const val DELDOUL = 4905
        const val SALI = 4906
        const val AKABLI = 4907
        const val METARFA = 4908
        const val OULED_AISSA = 4909
        const val CHAROUINE = 4910

        // 50 - Wilaya de Bordj Badji Mokhtar (2 Communes)
        const val BORDJ_BADJI_MOKHTAR = 5001
        const val TIMIAOUINE = 5002

        // 51 - Wilaya de Ouled Djellal (6 Communes)
        const val OULED_DJELLAL = 5101
        const val DOUCEN = 5102
        const val CHAÏBA = 5103
        const val RAS_EL_MIAAD = 5104
        const val BESBES = 5105
        const val SIDI_KHALED = 5106

        // 52 - Wilaya de Béni Abbès (10 Communes)
        const val BENI_ABBES = 5201
        const val TAMTERT = 5202
        const val OULED_KHOUDIR = 5203
        const val KSABI = 5204
        const val KERZAZ = 5205
        const val TIMOUDI = 5206
        const val EL_OUATA = 5207
        const val BENI_IKHLEF = 5208
        const val MERIDJA = 5209
        const val IGLI = 5210

        // 53 - Wilaya d'In Salah (3 Communes)
        const val IN_SALAH = 5301
        const val FOGGARET_EZZOUAIA = 5302
        const val IN_GHAR = 5303

        // 54 - Wilaya d'In Guezzam (2 Communes)
        const val IN_GUEZZAM = 5401
        const val TIN_ZAOUATENE = 5402

        // 55 - Wilaya de Touggourt (11 Communes)
        const val TOUGGOURT = 5501
        const val NEZLA = 5502
        const val TEBESBEST = 5503
        const val ZAOUIET_EL_ABIDIA = 5504
        const val TAMELLAHT = 5505
        const val MGGARINE = 5506
        const val SIDI_SLIMANE_55 = 5507
        const val BLIDET_AMOR = 5508
        const val TAYEBAT = 5509
        const val BEN_NACEUR = 5510
        const val EL_HADJIRA = 5511

        // 56 - Wilaya de Djanet (2 Communes)
        const val DJANET = 5601
        const val BORDJ_EL_HAOUAS = 5602

        // 57 - Wilaya d'El M'ghair (8 Communes)
        const val EL_MGHAIR = 5701
        const val SIDI_KHELIL = 5702
        const val KOUIMEL = 5703
        const val OUM_TOUYOUR = 5704
        const val STILL = 5705
        const val DJAMAA = 5706
        const val M_RARA = 5707
        const val SIDI_AMRANE = 5708

        // 58 - Wilaya d'El Meniaa (4 Communes)
        const val EL_MENIAA = 5801
        const val HASSI_FEHAL = 5802
        const val HASSI_GARA = 5803
        const val MANSORAH_58 = 5804

    }





}