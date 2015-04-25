package uncc.parkability.com.parkabilityuncc.data;

import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * An enum for the static information for each of the bus routes used on campus
 *
 * @author Austin Beeeeeeeeeeeeeeeeler
 * @version 4/25/15
 */
public enum BusRoute {
    RED_50(Color.RED,
            new LatLng(35.3079548803,-80.7330054045),
            new LatLng(35.3079811463,-80.7333379984),
            new LatLng(35.3079636356,-80.7336491346),
            new LatLng(35.3079286143,-80.7342338562),
            new LatLng(35.3078541938,-80.734641552),
            new LatLng(35.3078137002,-80.7356084883),
            new LatLng(35.3078147947,-80.7356017828),
            new LatLng(35.3078257389,-80.7365217805),
            new LatLng(35.30695,-80.73652),
            new LatLng(35.3068429438,-80.7365727425),
            new LatLng(35.30663,-80.73669),
            new LatLng(35.3066503233,-80.7367712259),
            new LatLng(35.3066634565,-80.7386568189),
            new LatLng(35.30669,-80.73878),
            new LatLng(35.3067313115,-80.7388794422),
            new LatLng(35.30682,-80.73897),
            new LatLng(35.3070749633,-80.7391235232),
            new LatLng(35.30719,-80.73924),
            new LatLng(35.30747,-80.73995),
            new LatLng(35.3075893438,-80.7401427627),
            new LatLng(35.30775,-80.74032),
            new LatLng(35.30812,-80.74051),
            new LatLng(35.3082744498,-80.740545094),
            new LatLng(35.30865,-80.74055),
            new LatLng(35.30887,-80.74064),
            new LatLng(35.30907,-80.74086),
            new LatLng(35.3093425907,-80.741301477),
            new LatLng(35.30938,-80.74126),
            new LatLng(35.30938,-80.74126),
            new LatLng(35.30938,-80.74126),
            new LatLng(35.30946,-80.74119),
            new LatLng(35.3096621547,-80.741430223),
            new LatLng(35.30979,-80.74152),
            new LatLng(35.31012,-80.74163),
            new LatLng(35.3102881462,-80.7416367531),
            new LatLng(35.31044,-80.74158),
            new LatLng(35.3106317829,-80.7414838672),
            new LatLng(35.31083,-80.74133),
            new LatLng(35.31094,-80.74135),
            new LatLng(35.31094,-80.74135),
            new LatLng(35.31094,-80.74135),
            new LatLng(35.311,-80.7414),
            new LatLng(35.31162,-80.74076),
            new LatLng(35.3117436674,-80.7406309247),
            new LatLng(35.3118268392,-80.7404592633),
            new LatLng(35.31195,-80.7402),
            new LatLng(35.31215,-80.74026),
            new LatLng(35.31234,-80.74039),
            new LatLng(35.31289,-80.74116),
            new LatLng(35.31207,-80.742),
            new LatLng(35.31211,-80.74215),
            new LatLng(35.31205,-80.74231),
            new LatLng(35.31192,-80.74236),
            new LatLng(35.31179,-80.74229),
            new LatLng(35.31162,-80.74247),
            new LatLng(35.31162,-80.74247),
            new LatLng(35.31162,-80.74247),
            new LatLng(35.30968,-80.7445),
            new LatLng(35.30968,-80.7445),
            new LatLng(35.30968,-80.7445),
            new LatLng(35.309403877,-80.7441526651),
            new LatLng(35.3095921134,-80.743932724),
            new LatLng(35.3098810334,-80.7442975044),
            new LatLng(35.31179,-80.74229),
            new LatLng(35.31175,-80.74215),
            new LatLng(35.31182,-80.74199),
            new LatLng(35.31196,-80.74194),
            new LatLng(35.31207,-80.742),
            new LatLng(35.31232,-80.74175),
            new LatLng(35.31232,-80.74175),
            new LatLng(35.31232,-80.74175),
            new LatLng(35.31289,-80.74116),
            new LatLng(35.31234,-80.74039),
            new LatLng(35.31215,-80.74026),
            new LatLng(35.31195,-80.7402),
            new LatLng(35.31175,-80.74062),
            new LatLng(35.31085,-80.74155),
            new LatLng(35.31085,-80.74155),
            new LatLng(35.31085,-80.74155),
            new LatLng(35.3107346548,-80.7416662574),
            new LatLng(35.3106,-80.74174),
            new LatLng(35.3104917019,-80.7418003678),
            new LatLng(35.31036,-80.74183),
            new LatLng(35.3101874626,-80.7418593764),
            new LatLng(35.31001,-80.74183),
            new LatLng(35.3098525792,-80.7417842746),
            new LatLng(35.3097,-80.7417),
            new LatLng(35.3097,-80.7417),
            new LatLng(35.3097,-80.7417),
            new LatLng(35.30944,-80.74147),
            new LatLng(35.30907,-80.74086),
            new LatLng(35.30887,-80.74064),
            new LatLng(35.30865,-80.74055),
            new LatLng(35.3082788274,-80.740545094),
            new LatLng(35.30812,-80.74051),
            new LatLng(35.30775,-80.74032),
            new LatLng(35.3075959103,-80.7401534915),
            new LatLng(35.30747,-80.73995),
            new LatLng(35.30719,-80.73924),
            new LatLng(35.3070924742,-80.7391369343),
            new LatLng(35.30682,-80.73897),
            new LatLng(35.3067313115,-80.7388821244),
            new LatLng(35.30669,-80.73878),
            new LatLng(35.3066634565,-80.7386595011),
            new LatLng(35.30665,-80.73678),
            new LatLng(35.30661,-80.73663),
            new LatLng(35.3067882221,-80.7364949584),
            new LatLng(35.30689,-80.73644),
            new LatLng(35.3078213612,-80.7364305854),
            new LatLng(35.307810417,-80.7356058061),
            new LatLng(35.307810417,-80.7356125116),
            new LatLng(35.3078541938,-80.7347434759),
            new LatLng(35.3078541938,-80.734641552),
            new LatLng(35.3078804598,-80.7344940305),
            new LatLng(35.3079286143,-80.7342660427),
            new LatLng(35.3079680133,-80.7336437702),
            new LatLng(35.3079844296,-80.7333312929),
            new LatLng(35.3079505026,-80.7330161333),
            new LatLng(35.3079636356,-80.7326607406),
            new LatLng(35.3079614468,-80.7326714694),
            new LatLng(35.3079636356,-80.7316750288),
            new LatLng(35.3079680133,-80.7308703661),
            new LatLng(35.307959258,-80.7304733992),
            new LatLng(35.3079505026,-80.7303071022),
            new LatLng(35.3079505026,-80.7303607464),
            new LatLng(35.3079636356,-80.7299906015),
            new LatLng(35.3079548803,-80.7293200493),
            new LatLng(35.30915,-80.72932),
            new LatLng(35.30915,-80.72932),
            new LatLng(35.30915,-80.72932),
            new LatLng(35.31075,-80.72928),
            new LatLng(35.31075,-80.72928),
            new LatLng(35.31075,-80.72928),
            new LatLng(35.31088,-80.72927),
            new LatLng(35.3109,-80.72816),
            new LatLng(35.3108725466,-80.727981627),
            new LatLng(35.31082,-80.72781),
            new LatLng(35.31082,-80.72781),
            new LatLng(35.31082,-80.72781),
            new LatLng(35.30979,-80.72541),
            new LatLng(35.3096884201,-80.7252886891),
            new LatLng(35.3095986797,-80.7252216339),
            new LatLng(35.3095144112,-80.7251733541),
            new LatLng(35.3091762418,-80.7251183689),
            new LatLng(35.309174053,-80.7251183689),
            new LatLng(35.3089901933,-80.7250928879),
            new LatLng(35.3088851304,-80.7250767946),
            new LatLng(35.3087833506,-80.7250486314),
            new LatLng(35.3086585881,-80.7249949872),
            new LatLng(35.3085097484,-80.7248850167),
            new LatLng(35.3083565308,-80.724722743),
            new LatLng(35.3082744498,-80.7246047258),
            new LatLng(35.30814312,-80.7243794203),
            new LatLng(35.3078979705,-80.7245242596),
            new LatLng(35.3075608888,-80.7246369123),
            new LatLng(35.3072807159,-80.7246744633),
            new LatLng(35.3071362513,-80.7255059481),
            new LatLng(35.3070443192,-80.7257527113),
            new LatLng(35.3069195541,-80.725953877),
            new LatLng(35.3069239318,-80.7259458303),
            new LatLng(35.30587,-80.72743),
            new LatLng(35.30587,-80.72743),
            new LatLng(35.30587,-80.72743),
            new LatLng(35.30561,-80.72779),
            new LatLng(35.30557,-80.72798),
            new LatLng(35.30559,-80.72805),
            new LatLng(35.3060374369,-80.7281452417),
            new LatLng(35.3061731479,-80.7282096148),
            new LatLng(35.3062519477,-80.7283222675),
            new LatLng(35.30675,-80.72934),
            new LatLng(35.30685,-80.72941),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30767,-80.72931),
            new LatLng(35.3079636356,-80.7293093204),
            new LatLng(35.3079636356,-80.7297760248),
            new LatLng(35.307946125,-80.7303071022),
            new LatLng(35.307946125,-80.7302641869),
            new LatLng(35.3079548803,-80.7304465771),
            new LatLng(35.3079636356,-80.7308757305),
            new LatLng(35.3079548803,-80.7316696644),
            new LatLng(35.3079636356,-80.732640624),
            new LatLng(35.3079548803,-80.7330322266)),

   GREEN_49(Color.GREEN,
            new LatLng(35.30117,-80.7358620117),
            new LatLng(35.30117,-80.73417),
            new LatLng(35.30126,-80.73369),
            new LatLng(35.30139,-80.7334),
            new LatLng(35.30153,-80.73322),
            new LatLng(35.30178,-80.73301),
            new LatLng(35.3020216417,-80.7328979883),
            new LatLng(35.30202,-80.7329),
            new LatLng(35.30233,-80.73261),
            new LatLng(35.30249,-80.73216),
            new LatLng(35.30246,-80.73203),
            new LatLng(35.30248,-80.73194),
            new LatLng(35.30267,-80.73174),
            new LatLng(35.30276,-80.73154),
            new LatLng(35.30287,-80.73089),
            new LatLng(35.30286,-80.72973),
            new LatLng(35.302917189,-80.7295917202),
            new LatLng(35.30297,-80.72955),
            new LatLng(35.3032724883,-80.7294887172),
            new LatLng(35.3032905472,-80.7294867055),
            new LatLng(35.3032889055,-80.729486035),
            new LatLng(35.3033622638,-80.7294780466),
            new LatLng(35.3034717399,-80.7294452479),
            new LatLng(35.3035282835,-80.729391516),
            new LatLng(35.30361,-80.72926),
            new LatLng(35.30366,-80.72855),
            new LatLng(35.3037172638,-80.7283934258),
            new LatLng(35.30378,-80.72832),
            new LatLng(35.3039591765,-80.7282390963),
            new LatLng(35.30403,-80.72824),
            new LatLng(35.3049583078,-80.7282377779),
            new LatLng(35.3050863594,-80.7282297313),
            new LatLng(35.3050863594,-80.7282297313),
            new LatLng(35.3052209775,-80.7281894982),
            new LatLng(35.3053052505,-80.7280795276),
            new LatLng(35.3053151005,-80.7280312479),
            new LatLng(35.3053424619,-80.7279856503),
            new LatLng(35.3053818622,-80.7279467583),
            new LatLng(35.3054212625,-80.7279293239),
            new LatLng(35.3054683239,-80.7279185951),
            new LatLng(35.3055197632,-80.7279320061),
            new LatLng(35.3055712024,-80.7279735804),
            new LatLng(35.3055974692,-80.7280620933),
            new LatLng(35.3057244253,-80.7281063497),
            new LatLng(35.30575,-80.72813),
            new LatLng(35.30605,-80.72815),
            new LatLng(35.30617,-80.72821),
            new LatLng(35.3062628921,-80.7283356786),
            new LatLng(35.30675,-80.72934),
            new LatLng(35.3068620388,-80.7294086589),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30915,-80.72932),
            new LatLng(35.30915,-80.72932),
            new LatLng(35.30915,-80.72932),
            new LatLng(35.31075,-80.72928),
            new LatLng(35.31075,-80.72928),
            new LatLng(35.31075,-80.72928),
            new LatLng(35.31095,-80.72925),
            new LatLng(35.31109,-80.72971),
            new LatLng(35.31154,-80.73032),
            new LatLng(35.3116276644,-80.7304626703),
            new LatLng(35.31169,-80.73061),
            new LatLng(35.3117808758,-80.7308730483),
            new LatLng(35.31182,-80.73115),
            new LatLng(35.31181,-80.73202),
            new LatLng(35.31228,-80.73199),
            new LatLng(35.3129014993,-80.7319754362),
            new LatLng(35.3131641432,-80.731986165),
            new LatLng(35.3133228234,-80.7318601012),
            new LatLng(35.3135099563,-80.7318627834),
            new LatLng(35.3135055789,-80.7318627834),
            new LatLng(35.3136084471,-80.7319271564),
            new LatLng(35.3136193905,-80.7319968939),
            new LatLng(35.3139520697,-80.7320022583),
            new LatLng(35.3139958432,-80.731779635),
            new LatLng(35.3140746353,-80.7317635417),
            new LatLng(35.3141293521,-80.7317984104),
            new LatLng(35.3141534275,-80.7318547368),
            new LatLng(35.3141556161,-80.7320076227),
            new LatLng(35.3129014993,-80.7319754362),
            new LatLng(35.3122864715,-80.7319942117),
            new LatLng(35.31181,-80.73202),
            new LatLng(35.31188,-80.73259),
            new LatLng(35.31187,-80.73376),
            new LatLng(35.31187,-80.73376),
            new LatLng(35.31187,-80.73376),
            new LatLng(35.312,-80.73492),
            new LatLng(35.31199,-80.73522),
            new LatLng(35.31194,-80.73541),
            new LatLng(35.3118,-80.73566),
            new LatLng(35.3115,-80.73593),
            new LatLng(35.31123,-80.736),
            new LatLng(35.31077,-80.73594),
            new LatLng(35.31051,-80.73599),
            new LatLng(35.30975,-80.73641),
            new LatLng(35.30951,-80.73648),
            new LatLng(35.30793,-80.73652),
            new LatLng(35.30794,-80.73559),
            new LatLng(35.30794,-80.73559),
            new LatLng(35.30794,-80.73559),
            new LatLng(35.30795,-80.73471),
            new LatLng(35.30803,-80.73428),
            new LatLng(35.30808,-80.73361),
            new LatLng(35.30809,-80.73267),
            new LatLng(35.30809,-80.73267),
            new LatLng(35.30809,-80.73267),
            new LatLng(35.30808,-80.73038),
            new LatLng(35.30808,-80.73038),
            new LatLng(35.30808,-80.73038),
            new LatLng(35.3081,-80.72932),
            new LatLng(35.3076659534,-80.729341507),
            new LatLng(35.30686,-80.72941),
            new LatLng(35.30686,-80.72941),
            new LatLng(35.3068643777,-80.72941),
            new LatLng(35.30675,-80.72934),
            new LatLng(35.30626,-80.72834),
            new LatLng(35.30615,-80.72819),
            new LatLng(35.3060483813,-80.7281506062),
            new LatLng(35.30575,-80.72813),
            new LatLng(35.3057167641,-80.7281599939),
            new LatLng(35.3055722968,-80.7281787694),
            new LatLng(35.3055350855,-80.7282216847),
            new LatLng(35.3054716073,-80.7282525301),
            new LatLng(35.3054037513,-80.7282458246),
            new LatLng(35.3053435563,-80.728225708),
            new LatLng(35.3052242608,-80.7281921804),
            new LatLng(35.30512,-80.72822),
            new LatLng(35.30512,-80.72822),
            new LatLng(35.3051224764,-80.7282176614),
            new LatLng(35.3050890955,-80.7282310724),
            new LatLng(35.30495393,-80.7282404602),
            new LatLng(35.30396,-80.72824),
            new LatLng(35.30378,-80.72832),
            new LatLng(35.3037178111,-80.7283947669),
            new LatLng(35.30366,-80.72855),
            new LatLng(35.30361,-80.72926),
            new LatLng(35.30353,-80.72939),
            new LatLng(35.303469427,-80.7294467347),
            new LatLng(35.3034077596,-80.7294659184),
            new LatLng(35.3033672638,-80.7294793294),
            new LatLng(35.30337,-80.72948),
            new LatLng(35.30307,-80.72951),
            new LatLng(35.30297,-80.72965),
            new LatLng(35.30297,-80.73087),
            new LatLng(35.30292,-80.7313),
            new LatLng(35.3028,-80.73165),
            new LatLng(35.30278,-80.73192),
            new LatLng(35.3028,-80.732),
            new LatLng(35.30311,-80.7321),
            new LatLng(35.30432,-80.73213),
            new LatLng(35.3043272638,-80.732515627),
            new LatLng(35.3043289055,-80.7325853644),
            new LatLng(35.30433,-80.73258),
            new LatLng(35.30426,-80.73344),
            new LatLng(35.30426,-80.7345378718),
            new LatLng(35.30426,-80.7345673761),
            new LatLng(35.30426,-80.73456),
            new LatLng(35.30426,-80.73666),
            new LatLng(35.30431,-80.73714),
            new LatLng(35.304,-80.73732),
            new LatLng(35.30338,-80.73792),
            new LatLng(35.3029685573,-80.7381552458),
            new LatLng(35.3028229906,-80.7378105819),
            new LatLng(35.3028240851,-80.737811923),
            new LatLng(35.3026051873,-80.737452507),
            new LatLng(35.3024432025,-80.7373827696),
            new LatLng(35.3019660023,-80.7373934984),
            new LatLng(35.3013749706,-80.737388134),
            new LatLng(35.3012261174,-80.737195015),
            new LatLng(35.3011692029,-80.7369267941),
            new LatLng(35.30117,-80.73586)),

    YELLOW_47(Color.YELLOW,
            new LatLng(35.30117,-80.73586),
            new LatLng(35.3011823371,-80.7368302345),
            new LatLng(35.3012173614,-80.7370769978),
            new LatLng(35.301440641,-80.7372325659),
            new LatLng(35.3018259063,-80.737259388),
            new LatLng(35.3021498779,-80.7372808456),
            new LatLng(35.3025789195,-80.7373827696),
            new LatLng(35.3027321481,-80.7374686003),
            new LatLng(35.3028284631,-80.7377314568),
            new LatLng(35.302832841,-80.7377314568),
            new LatLng(35.3029685573,-80.7381498814),
            new LatLng(35.3032356114,-80.7380211353),
            new LatLng(35.3034895308,-80.7378280163),
            new LatLng(35.3040061231,-80.7373452187),
            new LatLng(35.3044132655,-80.7371360064),
            new LatLng(35.3043519754,-80.7366424799),
            new LatLng(35.3043574477,-80.7346107066),
            new LatLng(35.3043574477,-80.7346321642),
            new LatLng(35.3043782426,-80.7334345579),
            new LatLng(35.3043990374,-80.7327894866),
            new LatLng(35.3044165489,-80.732498467),
            new LatLng(35.3044176434,-80.7325065136),
            new LatLng(35.3044395327,-80.7322704792),
            new LatLng(35.30319,-80.73225),
            new LatLng(35.30298,-80.73218),
            new LatLng(35.30263,-80.73225),
            new LatLng(35.30248,-80.73214),
            new LatLng(35.30247,-80.73197),
            new LatLng(35.30273,-80.73162),
            new LatLng(35.30285,-80.73112),
            new LatLng(35.30286,-80.72973),
            new LatLng(35.30297,-80.72955),
            new LatLng(35.30329,-80.72948),
            new LatLng(35.30329,-80.72948),
            new LatLng(35.30329,-80.72948),
            new LatLng(35.30344,-80.72946),
            new LatLng(35.30361,-80.72926),
            new LatLng(35.30366,-80.72855),
            new LatLng(35.30378,-80.72832),
            new LatLng(35.30403,-80.72824),
            new LatLng(35.30509,-80.72823),
            new LatLng(35.30522,-80.72818),
            new LatLng(35.30535,-80.72797),
            new LatLng(35.30543,-80.72792),
            new LatLng(35.30543,-80.72792),
            new LatLng(35.30543,-80.72792),
            new LatLng(35.30552,-80.72793),
            new LatLng(35.30559,-80.72805),
            new LatLng(35.30575,-80.72813),
            new LatLng(35.30605,-80.72815),
            new LatLng(35.30617,-80.72821),
            new LatLng(35.30675,-80.72934),
            new LatLng(35.30685,-80.72941),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30699,-80.72939),
            new LatLng(35.30767,-80.72931),
            new LatLng(35.3082700721,-80.7293200493),
            new LatLng(35.3082875827,-80.7303500175),
            new LatLng(35.3082875827,-80.7303285599),
            new LatLng(35.3082788274,-80.7330858707),
            new LatLng(35.3082788274,-80.7330322266),
            new LatLng(35.3082000296,-80.734180212),
            new LatLng(35.3081474977,-80.734770298),
            new LatLng(35.308116854,-80.7356286049),
            new LatLng(35.3081212317,-80.7356071472),
            new LatLng(35.3081387423,-80.736540556),
            new LatLng(35.30691,-80.73653),
            new LatLng(35.30629,-80.73696),
            new LatLng(35.30603,-80.73707),
            new LatLng(35.3046,-80.73708),
            new LatLng(35.3044045098,-80.7371306419),
            new LatLng(35.3043497864,-80.7366612554),
            new LatLng(35.3043563532,-80.7345986366),
            new LatLng(35.3043574477,-80.7346241176),
            new LatLng(35.3043782426,-80.7334506512),
            new LatLng(35.3044001319,-80.7327800989),
            new LatLng(35.3044176434,-80.7324850559),
            new LatLng(35.3044176434,-80.7325065136),
            new LatLng(35.3044395327,-80.7322651148),
            new LatLng(35.30319,-80.73225),
            new LatLng(35.30298,-80.73218),
            new LatLng(35.30274,-80.73221),
            new LatLng(35.30263,-80.73225),
            new LatLng(35.3023,-80.73275),
            new LatLng(35.30184,-80.73297),
            new LatLng(35.30153,-80.73322),
            new LatLng(35.30129,-80.73361),
            new LatLng(35.30119,-80.73394),
            new LatLng(35.30117,-80.73586));

    private LatLng[] segments;
    private int color;

    private BusRoute(int color, LatLng... segments) {
        this.color = color;
        this.segments = segments;
    }

    public PolylineOptions getPolyLineOptions() {
        return new PolylineOptions()
            .add(segments)
            .color(color);
    }
}
