package Week20_2025;

/**
 * @RAHILKHERA
 *
 * LeetCode Problem: 3337 - Total Characters in String After Transformations II
 * Problem Link: https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/description/?envType=daily-question&envId=2025-05-14
 *
 * Input:
 *  - String: s
 *  - Number of transformations: t
 *  - Integer List: nums
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists only of lowercase English letters.
 * 1 <= t <= 10^9
 * nums.length == 26
 * 1 <= nums[i] <= 25
 *
 * Definition: Transformation
 * - Replace char ch in the string with the next nums[ch - 'a'] consecutive characters in the alphabet.
 *
 * Task: Find the length of the string after performing t transformations.
 *
 * Observations:
 * #1. Each character can affect the frequency of multiple characters in a single transformation.
 *     => nums specify how many next characters will be affected.
 *     => The range of characters is [0,26) for 'a' to 'z'.
 *     => If the index of the current character is i, then the next nums[i] characters are affected.
 *     => Wrapping is allowed (e.g., if character is 'z' and nums[25] = 3, then 'a', 'b', 'c' will be affected).
 *     => For every j from 1 to nums[ch - 'a'], affected char index (idx) = (i + j) % 26.
 *     => next[idx] += current[i]; summation as multiple characters can affect others in a single transformation.
 *
 * #2. Applying transformations t times directly results in TLE due to high constraints.
 *     => Use template from LeetCode_3335 with a condition for updating.
 *     => 529 test cases passed out of 536. TLE occurred.
 *
 * #3. Repeated transformations are computationally expensive.
 *     => This needs to be optimized.
 *     => The transformation depends on nums and remains the same throughout all t transformations.
 *     => T(c, c') represents the transformation from character c' to character c.
 *     => Both c and c' lie in [0, 26).
 *     => Store transformations in a 2D matrix T of size 26 x 26.
 *     => T(c,c') = 1 if c is generated from c' during transformation; else 0.
 *
 * #4. Let f(i,c) represent the number of occurrences of character c after i transformations.
 *     => f(i,c) = ∑ [T(c,c') * f(i-1,c')], from c' = 0 to 25.
 *     => First row of T matrix shows number of ways chars a to z can transform to 'a'.
 *     => First row of f matrix shows occurrences of char 'a' due to previous transformation.
 *     => Multiplication of each column of T with each row of f gives transformed results.
 *     => Summation of all character occurrences yields final string length.
 *     => This is matrix multiplication:
 *        - f(i,c): 26 x 1
 *        - T(c,c'): 26 x 26
 *        - f(i-1,c'): 26 x 1
 *
 * #5. f(i,c) = T^i * f(0,c')
 *    => f(1,c) = T * f(0)
 *    => f(2,c) = T^2 * f(0)
 *    => ...
 *    => f(t,c) = T^t * f(0)
 *    => Sum over f(t,c) gives final string length.
 *
 * #6. T^t: Matrix exponentiation
 *    => Compute T^t using fast exponentiation (similar to a^b).
 *    => Base is a matrix; initialize result as identity matrix (diagonal = 1).
 *    => Perform repeated squaring on the matrix.
 *
 * Approach:
 * 1. Matrix Logic
 *    => Create a class with:
 *       - property 'a': 2D array (26 x 26), to store transformations
 *       - copy constructor: for use in exponentiation
 *       - mul(): method to multiply two matrices
 *
 * 2. Generate identity matrix for initialization.
 *    => Identity matrix: diagonal = 1; size = 26 x 26
 *
 * 3. Matrix exponentiation:
 *    => Initialize result with identity matrix
 *    => Initialize current with the original matrix (via copy constructor)
 *    => While power > 0:
 *       - If power is odd, result *= current
 *       - current *= current
 *       - power /= 2
 *
 * 4. Compute transformation matrix T using (i + j) % 26
 *    => Count initial character frequencies: f(0)
 *    => Compute T^t using exponentiation
 *    => Multiply T^t with f(0) to get f(t)
 *
 * 5. Apply modulo 10^9 + 7 to all arithmetic operations
 *
 * Time Complexity: O(n + log t × |Σ|^3)
 *    - n = length of the string
 *    - |Σ| = 26 (alphabet size)
 *    - O(n) for counting initial frequencies
 *    - Matrix exponentiation = O(log t × 26^3)
 *
 * Space Complexity: O(26^2)
 *    - For storing transformation matrix
 */


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LeetCode_3337_TotalCharactersInStringAfterTransformations2 {

    @Test
    public void test1() {
        assertEquals(7, lengthAfterTransformations("abcyy", 2,
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2)));
    }

    @Test
    public void test2() {
        assertEquals(8, lengthAfterTransformations("azbk", 1,
                Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)));
    }

    @Test
    public void test3() {
        assertEquals(91272833, lengthAfterTransformations(
                "bvqbowlhpfhpaddcegzxiawnprkhbvqlmqegsydbykdrxywxvtjlqkuvzasrfdwgepgkbcsxebrkeegttxugleyzytnfpsjimuxqjpjgqbxtbrpntxgxaahldwwnemzwtpgnbvhqikibmqwkxjlvklnuidgwhrxdnwjzxgazfckirtzzwacsvinisjzjyaibwamcbjkcxkdzripdrgyeewkpgofezpcbjbpbdhzltzmqffaqrqcefjwyuyimzpftumzdkazbkijezidrcabvfiltkxzzyywxogsccxkmihqwmehuicpolzxxqvyjdtsuohwthzmigprfjooframjuckvqxjboowpmbdwokzprniwejbbbzwvspufgilhylgukfqgdkiuezvfhxsbpkorbouyqapbwlbezukjhbiiykncopskkzajggslrplccqqcnogvhzjprfyuanmuuwhbndkmasesrpgwdgjyvcscmtiwyhsexvahitchwswafbftffrfpnwepijdmxlzihsnszpjvztxjvxbcbepbfhzcvmxfdibhycvzmzsnqtowvnyqoprmlpfdemyxawlahnlyihrkauraudjvkbsovqhpfvuxletqienvlcwnwdntusvwrgmlaibacdmxwarakxiqiqaaihtnfdmkrtknqrhhsebeizjwrdavzldafamwkjvtavitzoyzwavorvcbclapuzeeigndagdbpbxnexumoshtbkzlhsqetyzqfhswuxnxtrmzjaxlzjsdmdhgpjtdoogehkcanyylfsgpceosbeokdzarlogagljrzadttgwaksswbakodwjtpysrhthgmlpjixcxrfgaqcnqlchanwivxngtorsrplqmrxmaqwairjmbepggtuajfmqtbrcgczlogwkrjzhiqdbqbrcrlpovgspnmuxdqewqlbhzchfxrcxblhoozxmasnmzelzzfclsklpxexzmnenoigazshmhwkfrlkbkyerupbgedosfmvdburuqfydstnjyjpmusnfokoyjvdgnphvotckwvageasfrsknnxnbvmqqlvtyvbgijndosppsfrbzmkkgzzufzecmyqnacfyuylrewbuybecszxxovsflslzbbpapzywgahkqohvlzdgeveoqjvawwehecdlgtnseubafazduxgwbxqzponpizvsjosjddwajtpvenwbsgtqtessiacspjiehlqvjhugextkjlhgfkqiseqjhfvkewugmmwksrlxrvnrmstlklaytbqwfvzaebkbwjsqfgvwdoorepxcxbelvaobjgtdjlvqyninoehfroviegdyiilrpewvgpdipfqlizzxzzfvhqizrdcgmpbjffljpzyljupwenvybbvcgwvgqnfcfdfjlckioxkwnqiurpodtduitawsinvtbfnhbmozwukjqapeewivqmtjuqtlwygzfujfovvabmwsmmousfvcmoedejhurbxrzbdrreqymtuqzyjojjncibhelurkwajdfvdmeiabxfaqqpiqishborzzkztsfskfbbqwwathksdbrvzfbncxkmretflmddtoyxthwibtfeeowiippwoccnmpcswoqstmjdesxkhriqhftdojbsghfudrutzgduxdnrrheksjdyzrdtbkdbcrjkfhlfkvuadhiqbpnqljrqprdwmthcgstakkrmhivuirdvmwqkswjgnmqcqziwqbqxhrhhbtgagbdibjilhzuhglolxwpfywltxqfvbbvkmgpasvxaforlbgkttrnmhszehynywnwbxkshrajhymvgexcsqcfmnhiyikmzkwxtwaebajwoxeqmehyqrxyairhlsbazvkdbqhebtovualatufvauqeczcrrkyletfobzjvcauvnunnzogkdznfwstrkoicafynnbbdlutkeauqwyhqrdkgtrdbngeljgdfrvfiiampsuawxpsoosedtnnjwtdkwoykbukipvsvyefwkmlkrezsglrjnvafyyvbirnjkqgcobuhnwumbjwuyuoluyjmihghzlbrkkjewnobcuwopkdvokmqqwkpesgkgqowcxglywloojdjfhzeoihselaabpghovbwgaxwpdonuthapdunjpqldjkzovybxpzomvviutgljkpbdimbmanzyyzghlnwohqpjxupzrrhcrqzqhiupkinhjoniwoyxlgadvdlqnfwjucdcvvzmezbsqtcotbrmmjtlaihilpccrpszratqghwktpzciqexyqrbxnzfjbevsucqhmaaaedekipvhlbpscrwjwkzyodhssywlikjfmdbceehcvrhkdjxtvgtqmomaraninjzhvwzdteirgubbpochqocexfqxnqmqngezpedgpsiltsramrukxshrfhnuvsxafjfgkmqyapytiaeujczucwceyecjjbgbdmoavohqovlsunwbglroncvekqqbkuijehjbnyteoaegycbygfkfekkqnqcrktbbaksrcgyqmqnrttmhpefhzlmvoajypyrdchmyibgfbjgumrdfchliqdjjmoztvchtdzckjyzwyvfvabscxgymxosfstoagmvpvdofemlfzfkvexwrphbfxfsgumjvkisvvrpjztcxuhzqjwoatzqyiwjsvoismgadkxnejpbzhdymjbgejoboelmdpspqisukmzdytpqzbzpdhtyruutllgsipecruztupxjxnpgbcgtbhhkwcpcscjeebjzaxambflggzdhaupwjsswizkabaapecazfohbesowsyttexkqlayvnghvpcrhglqioufwxdhyqiyeedfioepddqmqzgvbvnkdbkkjujwrlfuxjfbuhicxnanjghbtnfdfxrcxdrqadmbpascwccifcpubjarrnzwtpglzowwekotstiwxlzyiesiqtbhoelbugxricrngzpxdarztndqnwtztoexcfsfffybkztsiwzarvzxesxrioahfheolpqneizdobicukwymgajilvdbxjbzzzqrjcoihgjlofofkxsbfmztousxolyfynxttrfhurvacvuqmvdmvdpvjefvwnmvcjqfleifbgntlwhynrqprngfcahzayyxrpunwtqmzczmigqpmmfyvvqciskpjxmimbdtttzfimioenelferxtcudmalkbqojuyrptrcrcgokjzromzeeyuznjprormpqtkjrzuwncumgrtpruqpvuiaseftkzhqdcywcovjytkvxkutknlymoiwknogudokqmwvmkqcxbyafpnmderopxihtuvtacnmkshhskozpysvfinvkseyhhdycmvcqmxaqbhbvzsdzlguqquqcabykcsqaeefmvgfmevsnukwrytcdxnmvpbfqekcjmccqfqswmotyxeezypgarndmalaagviyyenfruxcnwqtgyxifstfgbsdmlwtxmkoahobzemdrbwccufimsktsaluysyigwaveuezhfuqniciriejhwrgdzuvtducvkydelsfthgxizobpfciquywfqhhpsthfipenbotvizyqrvtfhkzvepscmfauhctmkhhyjjrmusjdwfuynghbwaorifkffnetqehbkapoqojkkubfxoisdouzqxejadzulqfquzmlaretcrrcjscjklfufuizrtvosthcecivbogxllpxzoihiirvderqkxhekqxaelgvippqonvwsifzoytfennzidgwmrppdlwwfcvuszmsmmqsftuhnauohniuftzbabhwdekllsszmloqjosdmptpuusnnzkrrxdyccjoxyoavkgdwbwkliaotzjlesbiahathesagnlrfezqorgyukasxnlnqlmcfokqztpcczlsvytwmrphmceyqtnvntwmmljfisyiszhacfyhrikvbkejblryhfgdwumwzstpzcgptphqmqqnfttuqjshcmmzfkopbqalbxjrscbefblkuhbzmnodgajzoqnkhzwsfhpvgokcyaqqybcwbqyrpdzqdtfiayvophivvfwgkigcqttxpigpqxvyvtfkmdgsdijxihcyiykdhxiyepcoxkpjirsdeezsjlogbguvshcasuvvpyrybcuvqbqtaddveyndsnrjdffszzhvknbsrcaeouyfqggpxzutgoxmkanvzkztnelncpxsjcimfoefqivpqrfvkgitwwwqtqisozoxuxheaumhntikfzlgvojnecympqdnbeghyktnzbbpcpfdqfnyihjchqtmgouwoevkylhzyxmmkoiywopdwfueznukqgxdxvgvqlxmptdszochifankbozlktpmstvllvkqytxywteiidxtvpdwurzuosonvmxjqgjteqmclsjxklopeiysjqjlkvabdqtmuvlalchllobcjxcxeicnvmgttkhxabkfxppktmptczytukbzmwymwmchawbohkqtajgiwbmlhvivmhdeeonngvcbgcsppbxeiooilgelxxuudkjxzzugcletjdtznqpzdalpzfhqzyrntljbnsbfpeeqvgpsrykunsmjjasnxmvmavuemnnvxcobjzvfvygzbdzyzrgxpqvarkwtlsbuiksjgsbhcneytfylsrokpcgjahljzfwusmlwydfhvqbjwdckzowqdhtgmtswsemghxhwlycaheudikfjfmpnuvfxrhfjjyeregrejcfcibtjjxnsyeohuhurrxyakklddbbruzxmjmbyhyrzqcjdazkvjdhebkfchywyqevqgpkwrfiwtssqvbzyovhaagqeekjcbzznziyymrlpbzclvttzwcpesswxvwknzpqdnzcfwwdanrvsgpfxakgchrkkguerurekcumuhlhoxhcddsvmxpnmkfddjcepsjnlxgqaqtmllpindndwwavcthnujkzfdkctnomipuctconyajkfvpwjjcwprzrzpjetmjwgumaxlriijkuanmqpuqlfofjdqxizbpdmphnavmsibtwsgpgtzqlxcldejedwigopiahgttqffdgyigxmmoinxjwsuljhtsjaifvcapgoxazoondpyvrdfodfqkuckyibcxykcxrzoxdxkwgjuafyshxaaofjxnftgjlswgtkbzyxxgawhrgliabdncnsfvmcuszkgtiogafcvtpssiqctlmaccvkqroobmnmirmtwhgcwxxuxghorsjauqkxjewjdbfamcgkakjlsryvawhsniuksmicjscbgcliccjrinjwtnghnecdpgjbkscuzrcvvdgigdrqmqocgwfxmosbpjwbjjafdnovgxhetphpydyogxuqyxxxqmyentbagcgfkufrbzqmzdljfhqxfdlrhvnavpouoeltrggaqvxaegboljjcladscdiddqihbzukbfcjgqahxlzvweqkokbpffhalieatflejpxstoseqossdrsbflrjolsksrboyewyxkvyodykugxinhgpcmqnzhlymvjmiybncvsvpvzldlytvhtqzocqugzvlrsuxnrkscscfvkpplovcikigyopogwojvwnxhguzxzrqjyduwpsojsimhogzhfmstjjyvsdnycpkjgynelbyszwddycgypflqkkobkyvxeccfcgixhoifxuehagwdkzztanhdivlsntppgcdajyyuhrtipsduanwkagmhcteousrweavrwqnncmxgdghjpcwjtaokhudyzxrxhnqwslgpoemjopsbjmuvtmfbyniuxskwuzdadvwueiohacxmfuddkkttddrqiiwsujeaeodbzguuddyzwnpycfknuojjdwayqyttpbsuqlyvbrgidmpzjnqbkagofrijikrittaxtiqqbwvtrnqutmzjfnqkashbdtisnfffihniknqeblchemzwsfhjoiotjmuolyprdfpidfpeutllwtavcdoreitatpdjififpfobnrhkowzjnbdoselynbewxagtzbetyriooufnpgjnzirjutvestaxbudtfwtlmhokedkuntejcyyzmhyeveyixyahwwmohmtuwvosqiiwokkyyiqdfiuqrylczllgbrmjpydskjblztygxgpeqfiikbsvrrmfmjjyjnmmcshmkhywnztmymcrsgpqmcvlypuydtrnyjxrlnjzkcwlzzvougctjsnzrdhqakyftwbybljakdsfmsexaxaxksvbqqvaegfestqfdsoaofaggyfhvkvhlvcbgtwdmnuwthivinencppqwxaojabpydxlcfblgysglnjoqkzywfwetjjshordjpfxawoupqpjtirmzylmpleuonnveqdtwzekqakrobsxbxqwildpuvkmlogtzzhwvuoztkspxekuvrqwzbzdzhjozqosnvmrucnspeorbrwlgbrqljqgmkuedgcjptzykyzmovpungwinhmrysehreebjtkafbglmrauhympjkarcyyldmzhkvjnkrtzdhhvtqoywsrbfiwswwzapmkbyewkbcujbyyxifbzigxsfoteelpywbjdfzvcnuwybbgndnbuenozmlpawibxklhgmcoodwipjettuhutambkyevapbhhumjhqfakarskfmjjpigrjsxlqhixovzdefqxymgnwcovfifjvubjaxoxtqmaidhtaqcsqggwxwjcsqqhlqysswpezaoarjssligvnccvbuejjbkwzxaikkcsrqmrdvmskgopzqlpxdouzuhsokcbweuwrzqcuqjxewhpmkrafivzurajyzlgsstlssdhfnjmjotyjqbnsjnfcvsptejrzicswkzvmhwumtprzhdxzqxjlnkgmociveqqrngydipsghrmntqymmqmwxrlovgxtepxfxlojwpmlzmenslyljtptkndyrjuikjrrurazgwgjginlfyuwmkogriokpxhbablkdwwnxxpjokfnlimmbeausuukteotoypwakqzeborvfwiolyvvxniukzwfzvubuvayzkhldwmbzpwjzmooryyxotosaaaecoivyqvqzqrylfdugcubmasktfpxpsvkqrqntipxlqpbjgpjootfvxbycvdolnrmcgvdkyjlyqjgozirijcwafdajnrokkubafhujulkfmqsewbllzqhkutsardfvkhswcpflausmcgjlhgskdsoppylvgulxvuquaehvssuoxfgqvidlmmocmbuhmzpmetmoewsokxpcnybnrmkpjxgebuydnftzxunbdmpqvttmpfziolhaoezdwhcrgsusxmgqgstwyojzwqtfnqvyjeihzpzjhzvhpffdnxejipduvvhwabolklhkgqoyqfupepibhjtnylnoivjfguohjlvtrxnjuqhhynebewhsmahwpqlpftmnvmjuaubcnunggqmwszhrhehpesvviafoxlmnvhdjcokoizxdtehtlxpucjyncistahijvmletwghdehijbxgqucdznemeexaxgkokqtpbhhlqxntxsflixprpwhkaubfiejpvcnavbopiezsfsdbaoeofrqzlneffagotrzvlkfwzlvncjglfcjxdxajggcqvceaobzdsmrcsrxjkxablpnmwodbvdwahnvsoxbiyayzerffyprleaurqqnuldoojygdufoqxgpnvdnwmbwllukunjtqxwyhsrqwwmtkgyclgbllxogtvjerxwhyrojvrulnklkixknnmgbmszxulhyykhhacfckkoplddkkbzaukxpdumdiodrswbomdlzdiifatlupwvlikgvhxczjfkrsuafrlorweihjgnpyuenavkpykgbavsfktiiqpclfuvtcotwztqprwjfimrsqocjpjditxjsueslhdduqrguwybzkchgiroqchlrosjwcjucfhhorckvcfoesztzthmxyeupmyrtkwsaoouhmzsufrtycbufjjsdqmmfkldqagajdmpyrwrfkvxgldmgojomwcinwhssttfxyrngqdeoqxucukowmskdmrsruegekxdbrnmhuegngcqxzvmoypplxqgsfivquhfnkxsxqnczhiuflwnmigstdnavsxvvvuvxzmjizyvybvqevjdklmmohsmywgjvonqreydevnioygjmzanipawurjotdvpkaevviyvvqpqrzydqygcazvrwugnzhhclaibjgsvwglzgxfaqrdmzqoblitmsbbjwfltnusrpyupgcbrrtbuqgxylnuobrldpzxirbgkbvsmhavdhmfbpbdzwqtqaqbezjovitosmgyatluomurdzchrtihtmoegzxppaworfoinixhytalzhhxlwvbgzujfgfwjldpwtzlzunobgylqrncyvzbsixbytwffodqjyxnofydjmtvnlmovvrfduguzfldsvwwcrmgtqsmjlfatxsfjzgxdxleowodnovisqywbwpufltlzjlayxkfiuvkztdiafjhudwsvnjitziacoeyysukccvnjyqwrltbbclnyagfjbnukqpdpltyiesbzhmueyrwpontbreoigznxdexiqbfbiietnisupsmvicxknbirlydwpyntpuwmsfmkrmpzrlcmgnddsvnmfisokxfuirptbyioexvinhnxbnkuyabirdgbksfwenrycvpijtlrgsipgzcdboiqucqsrotwceqoscccttorsboixxpbkvxefcwxqcndfwthnbfdqkagzxcgrtykccrtvjocomxksgfvaplxmnmqxpclduuvmbawppnngiotplzfevrenbqjsubzaelsqhvkditlmcrokwbbhvhwkjnbcbehwukixwapkxxnxfweqmjbwozdbgbjvrdjvcdywxsfkdidpybqyluwtulkiohtvcnmbiqkwaivoahykztaioxdptyzdvlyrqpqcyrvdxvarkgzavsmqsqoyrpgbaezlaizrcjqdvzdqtnlolkvivbnhdmgcxgsshwkutdtzybbaajaxfcgzuukfajnjlpppypbqokctsrakdnqpkrqmkriwjcuvohidahrtrhhwrvktnbkubvuarfbnicneqylpzztsrcyeixvbtrtulzmhrzgsyicqpuaygszlhjfrhoqmuuuokokfvkqwuybctjnnyjcaazswajpdrrzpdcshvvzdudclbtbmgnghbagcaetwolegcjunmhoejnwfpgcudwvqzatvwdjnmppdrwhfxivolidkqghlwhevqyeeanookdbmjjywvecepwmsjlymkwvpxspibxjzgyqowowiaisinfqfcppfnniaqxbuywulcqtgktssixggzbhdlxarsjygjocsjkxirhlcqjhlhgacuxxdmrqrcagyqxktpuryxyczeghsxsikqnvuwnttnjylzxobxiblesdlzsadasfiufvtvpihgfvupuxctmxgteszzorodcdfrvvgbxjljgbxpoaenoofvkyyltfipddwxinawdszinxaeevgdhtkndnifjnvfduhzxhgckayrljpzdaqdjebxhjglrtcbspmfyejytbumftarlqqywiquybqwjzgubkloqtuwekrkdvjvzxbzdawbapnduxrexmqffkpbmwrzmxpyftkooiuhzqzepvjfzpubfffluepcorcyaklidaiqggvyqiqdyhhrdisraftvmefzxrxukmdkzzevwowvvpixswrovgyuxrvqewspesfqxacajyqvsbnbfhbxuerjzvpmqvsxolfqsqxfmezfhqptnreuxfhnzxmgylfllzopvrlvsrghwcwpdihmtcfyyextjvzcxdfqtklifzdeusjbvounkthxxwhriutmroplcmtpsmbvcqzusejiciatpqsfxqqhunlksdfqvwbgrgezcvgpiqcmtgkuzqsejuihajgxlojeylpnfswwxbtawmtnujybesbdkbirnrdnjwmpmcufpupumfqfckvpoikmrhgcpigbnrraqceqttqxgawlkpngqvqclqbaznnyowgczpmctvpgyfromviulyojygqoswrwlrmzrpbcjeqnawaxqbolaqufbomrljaiafsfkrgpzszzskqmtcdhokteeuduvwlcnhdltalnrxihyjwyvdwtqxpgszygzcmnfcuwmqrdlxcfbyigayuwfgyxuddcdyrpinhihkboysyfnbgjveictgmiuaydbpikfhaxhwtqxhqxldxlopdheggjyrhfxyuibjxonbdrzdetzfqwdrbalnvtcjcmpvekxctqiceuztktyxdwpuokuuqmdjqzejwhmxtjfeukeaucyafoqkoirweonjjgvdqibqbgngdaamnivomhajsnronalruppsyxxfyeqjvfrtwbeusepthjiatatuqzrdlqepqflbbrvwqkoeaomviqedsphrabmxamxdbogptvarwfrvunitolfyjhmwebmtvwmshxmyfgctvkcziaojmqrzgpfunkvanhazchxlwkkzqkcygnrqnnsmenmyzwxouaalwxuwggbvyhdgijfwaqrrodreltjguejgsfppklwzirzsmalbdmcntrrfzvstsqiuzypgtowutqlphsovjxbuqhjmvtsztqfkfpntoztovadhyekpwcehrawhqafvucldevctklvjtextviyirtppkysjoqsgympgyvozrqiwfxzyrpresisbcskjhafhqzfflgaaiyxqwlwdggukkqjdwquynrjhfdudamhtetzgpcjcwtqmttdjyyfmbifjhugsijmkidrvhovvjkwhwqvzrdyzygbhjjueyzrdlfdcbhatvwtvnqpmnvfanjdydxwzcwvuptswhxvhivazcliiiykmvlhqbgqhveklurcwvrtalohuydnvmajexultfoqgxjmcorumsbutlbryilkrxgerhgccdzijpsyvwhvbduhnckozbsakpqlenptrigxeqqwqzzwqnjhyelztzlrursohxwhxfagxauzzywzdgtpdwbxndrxcvildtmftybitwlykbrvhpqwvwqdqzjbrwpbhxhopxzmjhwegbdclywaaidrguuzxthgntrkbxrbobterundhzddevsclkygaumdeafnfheumpzhvkiyaxkfpaikjzpiveukjhhptjvwppsexbyjvkbaiyvegbrzivzrpzpjrnfznjkonadraylahanfrscphmhzazpranzbyfzvrocnadbzpdmccvpkdqhfnblubmwapdgxvqwveocfbrfoarjkqyqwypfczlclzbnstwbfbmkcuvbbakhfhibytutpgxagvyvusvgtudhxtjkmgonjwlumqkbxpbnkmkmeeufpjcsdkkhfxadhykslduwchjjmmkrhzwhnvzrabtyqbisitowvpvmatbjykmozwlxqzzikzrivueboujhftrjlyqqytgarrfjjackuwtffilqzkmwpdcucccixafnydlicivadiwthsfehidckoexajvubqxeusfwqtebieoyvlrsmvttjmfidnktnjshvagpxclfudqpmoruenmsaipqsaoukmxoxdheasupjvagpznnjpkugvahlyokrgkpsaexlxjzjislhywlbpbtvtviiavgpclddnnpttyhrqixqojlwhialyfchlwzoeeaurrijftbmexifoolldnbdttnvuxmcjwgjgrxlehiporcmqfjasllvzykmcpkdbbcauyxmtbnwdzyzwzeidxncaqyorganedpxowjxcoyqbsuekkcavfggqbrfxgrcaqmelwodoxzirvwslonuqihdxyymrmewxufeqwfwhiulgznxfbmeimftsvcpotmtsynhfbqnknjwggwtqceviikbebcwcwqllfzcjiiosisbfrzilwynbvngahyljcckksktbqpgokiqinxaatckwvseihmbpofdqhrwmcclbnskfofydwtujiunlodasbvtmautgelnsephvuhmfcsxjndwzaupadwaertpxmqjvmzbnjeeyqgkttdjqgmbennhiudlxxzkqnomgytuntrmpzaqtfjqapbxmuenynknllhokuqclgspfxaicgqckvethhgvpkyusmeliulquhjzshgleuanttzvwlekvtwdqvvggwhgfwnkppagjbngfgbmxgogpkkkfhfdlbneemvvfhghuqtriovqtbylmzrwwhpsbxsstyqsuvkdvnvrrgsjmdqltznobotlqzocjaciecasgkjxbdwitbxhvledpcyjrytppduneivcaehsfpyrlirprgyeprslsizhyuzvzrqcxltyslydethcsercwgojhbrymzsvdldedhorubbhdoedksyaxkygpqaooofvgoqyziijimrivfmvpdpeawdykbxtstqfvnczgwjbvstairchhtczhcqlpkldczlhetflhdccuhkkfvbxfuomhaqbjsesqegwixwsidvzrmqadyortgxfxcqfgmxkspytkqfwvxrhlxudmmwrwmrbnutdjtzvjspcunxshcukgwjppaaewgtkrqatzjzkybhvpnuzncxzlncmbsccumqjgwwgrgufclsftqqqaszekqbivboitgnqmvekkqtrkrbzftargtjjbxsujhhxzhppilpoczgdwncudjfakdsmgvqtvcarxstftqqvibrepylsadrmavmjzksuhyfswkpiqeehrrrtsjwvveibpuuiqauvpsjzfphrrbrwqpufanqodrxcrycchzjgshvrmfvezxlpabswurgmybjsppasuwffibctmzrtzvjlegvtctgcudhrggiqfdzwivgzasbrckrqxztfmsavfnrabnwwkpwybyhrnxgecbdeelfhzoblwtpxzokxhnucwzemwuoqpmlxxzroejnbpyjweimvrwhksmvpaegzfriblojsfsughbsuahobhbiifnoamhacvjooocfwashsisuswrtflovjeqzwmgquimawljzplrqkqtsqhhnbnmzbyjeapuqbkbsxmlzzlfystovsvuadbbrwvwzttwyrkuosqotxnosypynmncyszwqnutjgrwiacvhpxkzkasyeccndwgivqcryqvnhabqxmevtrvhbrvktbwvehjhomcijmetfwvkiufxlivsrtlincwhxcfxvdtzudvntwgptujsxfarpbcschirbvqanybullkeglpqlwlkbgdpvcckutamtqaaqmaltijafgrdiqqrcjqzalakkslawvafechvyjbshnhdpqhbelkguecpcpcqayregfbrzcvmkzlncuvtqbblnbajihdfaurmslkgxmlhcpcyopgzdbjwnjfgjprtzcxdtbntjtdgzperhtqejdodejqoklgpnixcegximpfmklrvsuoyzwdjoapjroalbgcctorplbzxnmbeprxghmlebosmiqciimcizxmxsxcemwbaivqyqpprpsytoykurnptoapwwwxmxcngilvauocoflnderjzgtsbsmgdpxjtpktocdwapnmorlkdxejlqiieeuhlipdfspbnywvhjhskehjenzcxminfpyvfbuscqitrvvmggotvpdxqpjnwektqrmxhuwvookxxamwqfaglrtsxfamzlmtmfhmkdnnwaeqlmmiacedtiabnhqmasmvqgqqhyokorakgsrbkovggghjxvmmszypwtdxacryttzmntzzhrozpncyomwejjsdvqpnkducrpkvgjddoyfxldpdphvofcqhnsifoequdgbcfaweemyjhuynfmxraloocvtopntieetsarmxxgrueocagfelbhevltedxgicdexxvohqoeigmgswdznjlxfdkxxtdnlhjmwbtvjxdgmvmutrxpsdxadodngwwcmnvkobkxrllevlydqrycevosjehrxiblnanixvfuqibjtldtqhuyepapgkewyhjxtrsgmvybigtgqvqhhodzcpsvawpmckcjnuydcvfabciicqqkqldxgbgerwuxegdeiltjukctwolgspbkgindoibxvtsvfgmievtfzlxyxieerracaopiqvknexevvwqvobzxcqyfiyhcucpvreuuphlmaahhfyijdsszqttpnobzacggifhedlypnrzvkidjilmecrgbjtlelivvysxkmilwkyjyfcogkogigfzmqriqzehdohvjqcfltmatzdbxwygfqmnvklbjlzijmeawrlwmiilhxeiuyabuqhbxljgebeiuxjngvmjvvgmgutgqhjubhdmeurkahmpxyxadpxkdetirtnnjiwylusazcjlvgttxkrklrxroiribihnmaiorreqcaolhhvixkveqzoyiyskamagjfbpvfxnflsgrnykgcpfzhgepaouynjxmifcioqluxwzwpmtjprkesvxuvtnoklwljbpucwzruqhxtvipbjdbsinwxeghxyspnaodgcqkgoatocqqpxqxmwliqngjamryzbayfqbgjtpxoehhtuvtrrtphignupyalifnpflttcdildohkmwtohxckhnwejonlzozbsejdtzfvxkoxsxckbwvdgtcxoregmhahnuptgvsoiyjbmbcgjwjluadppzpqyctnqvwaecrpujxtourfiihvrhmmgrcapyeyndlkysnyyztpihpjyubuhzztzbrlkqnoowzrsumuqkqsigodofwtjyyhrjrinfbzrhbqkbiuyruftsgxvithmbdqwrkktpkpqxbqidaqeydydrdkqiizwkyhuzksfwiwoznnxeciivnfiowgzovtlmgwryxebkfunnbmpzuornqlemqrugzrpvqxykrfvlihxgexlsaipgicgmwqajagmbxdbfkwlxssqlcyuhwzmnzvlspufgkilutcirhlagdmthtjmkbjvbjwyzntfhmkbtpuejwbmymfqbuebhhwkseijlaqaejrmptvtryktsthepxsoofjimjxtacfaxttqhcoiebwytwxwsibeecwhgcjjvoukksphgqptneuqmhvrjewlouephrcnriejanwcjvchteskafqkgmbqxqyzjikslkpzjmaqfhzmkakonpeatytfyyncslnflvivvxclv",
                492153482, Arrays.asList(23, 20, 4, 11, 4, 24, 13, 25, 12, 21, 17, 7, 6, 21, 12, 11, 22, 25, 22, 16, 19,
                        8, 16, 18, 19, 16)));
    }

    private static final int L = 26;
    private static final int MOD = 1_000_000_000 + 7;

    private static class Mat {

        int[][] a = new int[L][L];

        Mat() {
        }

        Mat(Mat copyFrom) {
            for (int i = 0; i < L; i++) {
                System.arraycopy(copyFrom.a[i], 0, this.a[i], 0, L);
            }
        }

        Mat mul(Mat other) {
            Mat result = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    for (int k = 0; k < L; k++) {
                        result.a[i][j] = (int) ((result.a[i][j] + (long) this.a[i][k] * other.a[k][j]) % MOD);
                    }
                }
            }
            return result;
        }
    }

    private Mat identityMatrix() {
        Mat identityMatrix = new Mat();
        for (int i = 0; i < L; i++) {
            identityMatrix.a[i][i] = 1;
        }
        return identityMatrix;
    }

    private Mat matrixExponent(Mat m, int t) {
        Mat result = identityMatrix();
        Mat current = new Mat(m);

        while (t > 0) {
            if ((t & 1) == 1) {
                result = result.mul(current);
            }
            current = current.mul(current);
            t >>= 1;
        }
        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {

        // T(c, c')
        Mat transformation = new Mat();
        for (int i = 0; i < L; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                transformation.a[(i + j) % L][i] = 1;
            }
        }

        // f(0,c)
        int[] frequency = new int[L];
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        // T^t
        Mat powerMatrix = matrixExponent(transformation, t);

        int transformedLength = 0;
        // T^t * f(0,c) where c => (a,z)
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                transformedLength = (int) ((transformedLength + ((long) powerMatrix.a[i][j] * frequency[j])) % MOD);
            }
        }
        return transformedLength;
    }
}
