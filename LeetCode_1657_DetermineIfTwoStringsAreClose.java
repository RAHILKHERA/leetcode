import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class LeetCode_1657_DetermineIfTwoStringsAreClose {

    @Test
    public void test1() {
        assertTrue(closeStrings("abc", "bca"));
    }

    @Test
    public void test2() {
        assertFalse(closeStrings("a", "aa"));
    }

    @Test
    public void test3() {
        assertTrue(closeStrings("cabbba", "abbccc"));
    }

    @Test
    public void test4() {
        assertTrue(closeStrings("abbzccca", "babzzczc"));
    }

    @Test
    public void test5() {
        assertTrue(closeStrings(
                "byiwbiibwhyyyibybmbyjiembbbybiyhjbfdmuiiyebbqhbijibbifybbybwmbbyddyyibdiupybbmiymfimvijwypiufywybhbhbjyyyymyyyifwbwuyiybbbbjyjwmduvibfzbmbfyfjpyywiiyuyjbbyhwywbwibbyybiybbwjbfjebymiffyifyijbfiyibibyfbymfkwfbjjhiqiipjmyembwbjijuiuydimwjyeidubdwmdjdijjidyidwbbuwfybmybwyhyfyydbbujzjjuwybibdhiuyfbyjhdbuybybbuyfdlubiimjibijywyiyypbiybbpwywbmvuwuiyiwfbiwdbjiiibiwdiiibiimyfwwbybmjwbfyibixdmuybbdbfyewbyifuubmybbyibibyjwbbibbbwufdbbydifybmbyibidiuybbiuiidjmyuddzvyybyuibjhbbysefjbjmiidbfidybfbyyiybdbubiyhbfdbbbbibwwbmdiwydjbeymmqbihubpjyiuuhibidjidjyhbuhdiybjbidbjdbmddiubiiufymjbuuiwbbubyeeijefuwbyejiybybypyyhbdpbfwhjjbdwbiyiwybbfbiwymwdbbbbiiibbwmdydiuwddhbywbehbyfbizybmyhyiedyibbbmuyjimbyivfejqywdjbybubibyjdmdwbdbmmbjubuiubbbwhbbyhbymhihmdbhubjybdyuibbifbbbhbibybfbjyyjbffiybuemiiwhdbyjebbjyihiwbbyuifiydiybbibubfbifybbyhiiuhbbbbzidbwubwbhbiyybbbyhybyiihijhubfybyzdijbmfuoijiybyyyiubwbbyyyyjjujiyjbjedjdjwwbbyiduyfybyyudbydwiijbbjwybjmiyyyjbubwbcbjyybbmdmwbbjibbwwymbdbmiybiibbhmybybeibifyjybybejdibbbfmbybwyqjdwyibybwmdjbbjhfiyfuubbbfpwybyhjbbyybequyuywyyybjbyyiybwhhbiyiwbfyuyiwyfbjyhibyiiybiwbbjejibdyibbyyudyewypwyyyedfbpbbwyuyjmueyibijyjmyfujydiiyiwibiwuwimbwdyzeyfbfbzwydbbyiwudwjwbybbbjyybyjbbyfyybbiubbmbbibdimyiyybjffybmebbbfbjbuimyjfdbyjiwyyidybijiimwijyyibijdyjbbmeyubmdiwubiwwjfbwybbwihiiwbfuipmbiyebbwhyjfifbuwvdyybdyymfyifjiewmyiydbudbbubbyyiyimbjmwbjhiwfybyhwbibhwfwijmjbmbbebbyibbjbijdhffbdadwddifwbhjdybibwuymyyjbybdywbuebwwiyeymwymyuybyjbwyhimiyimwbzijwwdbhbyffjuybwhfbiibfiwhubyijbhwyuybbemfhfdbtymiyybjjbbyfmhyiymjiibbbdywfjwbbjbyiijubywdffjwmhdwijybwbmidyuyuyibbibibbhuiuibbzbyiwyeijdiebbdbwfbjiyibyifiiyeybbfdbibzbzbbyyfbbjyqmibbmbbiifdbwbbyjibmbyydibdhbbbyyibibyybdmymubjbybwfbuiyburybwbibhbhdjuiiiyufewjbiyjyyybiubizbyhbhyyiyibibbbhyjfijbyjmyybiiiyjbybjbjdduiwywdbumymibyybbbjwuifbbiwddbdddbjbjbdeijjqijiyjydjbiybybyibwhwyefbbyfbdybbdbbyhbywyymdbiybiihiywyjfbwwbdfhqhyuuhiwybbbibmybuyiyweyiiybbibwbhwfybyywjmybmjyieuufnjenbyzuyfimeyiydibmidmybiyfuiuwybbijbjibfyubbefdjziyejibbibhibyyjjwfyjemyhbhwyyiydiyybydmwmbzyfqwbjibjimfyhiuufbyhbmiyfyyyifebfbbbhbifbyidbdbbbwyybebiuubymiyyiiybfyijdiibbpymdmmibyfwufyyjbbumyduyyfyjiiyydbbyyyyfyyiwubbybiidewewiwbbjbbyiibffbubmwdybmwijyigbybymidwfyydyyjifjuybjybibnifjbyibyweyibbmjirbybuvwwuhimywujiymyebjbbhdumeyuiyy",
                "dikaziirmizqhrdkzikkiazirzviiiiaraikviiairimrdzihiziiizszizzizkiaimhaazdavmaaajlimrikzvhiiiikiizziikrijaiaimzaakizzmrakiziairzaraazraikraaidmihzjizsarzaizismirzsvaazkzsiiziivaaiikivsiiizmzaizrizzzzizikzmkiivijmiiiirvjiziisadrzizjssdiiijzrakqizizkvsazzzkaddmkivairuazsrqjrazzaijkrmzmdsivzddjziimikimmzsazhazjakzvzvzkriirzijmvavaiijurzafziavkrizizjkijzamadzivazzjaakjvavukkiiksizrvgvivivazkmaiijaivrdaskdmsriaizardaikasairakzvmkdsahdiziiiviiihzaavkzvazrizmsarzmikmjkaizifrrkkzmazdsmivvivaiviiizsacaamkzrsdzzaikmizmrzvzjjakazkzzzmzrzijazizimkrikzkiizzzhiizadirdiazdasviarzkirvsaizrisdazszhzziazizrdaziraasdiariaiizkmshumzzadrjaiiiizzsdjaziajziiszdzzsrrsrzzdsiqaihiridizdmadzekmrkismrbrziikrmmizizhrvmjvjzziahikiaajazsdaaikazzdrvjishakmdzajaajhjjivzzrzjaiikirimzijhjzizzzdzziiizazaazahrrzdaszvaavajzkradhhamviijzmkzjizahvksakrszzhisdiikrrzkkimarzizizhorzisrrizruaaijizaizhjizzraissiziarjirjamajadaiiiviaizizmvaazhzraimimvvaiazzkibzasikajkavaavmizzizzadiijajkiiiakikiksmdjzdzzmziikajjzzkzzziazjiairdaiiivisiazzzhdamhmzshrdiziziaazvzsaikrkizhaizrmzarzrzaadviavivdjiiavmziaazkkirddvihkiaiqziiiaijrzkazvazamzizizzsmikiiikddirjjizmrzzmvmzzijmkiivjiimriaidsazaidriakjajziikazaskahzazihrdiiiflzzddkidkzuzijmhzzidihzizidmiqaairmjdadrramaiiijrmaiaiiarjiiiidzmsazmahmjazijihkaiarkazirzazaiakjdvrivhrzazamaaiivzliiqijizzzjzaimzmmhiajimzkikjzikmakviizmijihzdiizizizzrivadaviaiiiiidvziaizzrisrfkirvizjzaidzjjrapkakzrzvvmaimzdidadrjumzaazjuhhziizkddzzrkiiimajmrsazazizdakmiasvkzmazrflkzzaiizhivdzdmvdairzimrrvrzisklzvrkjrkjdzdhzaziiidmiznixjaksiizviiiazzaizkzvizzkhdisvizjasziarzjlikizaidiramzjiamvdaraadrimiaikzaddzzdvaiirdariizriaaizziaizirmizdzizizzzivkakvikiizhiszvkdikiizimkmaiiiirmiiaaywszaiiziiviuzimiaajzzzmakvazvrmsaizaskramsrirzizirrimksvrsjzakavviziirjdfzvidaarmiizriikriarizzrajdzkzdziaiiviaidrsziakikkmiairaaziiiijjiaaiqazihiizziziidzqiiikzkamimiazvzadadzhdzzakvazzzrrkiimsazriiiijariiivzhdzhkarrsimaarzaizijlzdzazvkzazizmmkzqrzmaziziadvziidziiziizvzirizivijaiiaadszduivvkajrazdlimzjisijiqjiaisiabzmzitziraakvakkidmmqikvaiikjjikikjizzaaazizaijsqzvimjzvurmmkzriisdaivkzfmvdzzkazzdkjzkjiviirzrvmajziijmzizmuahikiijrivmaraivdadmirzravazaiimmiiqadzsvrirkzdjavksdlaiivirzlazaiadrjmiirvizizkzzkszizikaghvzmiiqzdmiqhvazmzhikairazkkiivmkjzraiiijaiukrzivjzazidkriziszizkzvarzmmaaiivhmuzmikzadz"));
    }

    @Test
    public void test6() {
        assertFalse(closeStrings("aabbbc", "bbcccd"));

    }

    // public boolean closeStrings(String word1, String word2) {

    // /**
    // * If lengths are not same, it cannot be close. No operations can make both
    // the
    // * strings close.
    // */
    // if (word1.length() != word2.length()) {
    // return false;
    // }

    // /**
    // * Sort the strings, if both the strings are same then they are close.
    // */

    // char[] word1Array = word1.toCharArray();
    // char[] word2Array = word2.toCharArray();
    // Arrays.sort(word1Array);
    // Arrays.sort(word2Array);

    // if (Arrays.equals(word1Array, word2Array)) {
    // return true;
    // }

    // /**
    // * If after sorting, if both are not same, then check if each character
    // * frequencey matches with frequencey of another character in the word.
    // *
    // * If it is true for all characters than it is close.
    // */

    // Map<Character, Integer> map1 = new HashMap<>();
    // Map<Character, Integer> map2 = new HashMap<>();

    // for (int i = 0; i < word2Array.length; i++) {
    // map1.compute(word1Array[i], (character, count) -> (count == null) ? 1 : count
    // + 1);
    // map2.compute(word2Array[i], (character, count) -> (count == null) ? 1 : count
    // + 1);
    // }

    // /**
    // * Both the words should be having same character set. Else it cannot be
    // closed.
    // */

    // for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
    // if (!map2.containsKey(entry.getKey())) {
    // return false;
    // }
    // }

    // Iterator<Map.Entry<Character, Integer>> iterator1 =
    // map1.entrySet().iterator();

    // while (iterator1.hasNext()) {

    // Map.Entry<Character, Integer> entry1 = iterator1.next();
    // Iterator<Map.Entry<Character, Integer>> iterator2 =
    // map2.entrySet().iterator();

    // while (iterator2.hasNext()) {
    // Map.Entry<Character, Integer> entry2 = iterator2.next();

    // if (entry1.getValue().equals(entry2.getValue())) {
    // iterator1.remove();
    // iterator2.remove();
    // break;
    // }
    // }
    // }

    // return map1.isEmpty() && map2.isEmpty();
    // }

    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        byte[] word1Byte = word1.getBytes();
        byte[] word2Byte = word2.getBytes();

        Arrays.sort(word1Byte);
        Arrays.sort(word2Byte);

        if (Arrays.equals(word1Byte, word2Byte)) {
            return true;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < word1Byte.length; i++) {
            count1[word1Byte[i] - 97]++;
            count2[word2Byte[i] - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 ^ count2[i] > 0) {
                return false;
            }

        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}
