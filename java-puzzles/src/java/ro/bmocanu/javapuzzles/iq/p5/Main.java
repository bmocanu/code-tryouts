package ro.bmocanu.javapuzzles.iq.p5;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> people = new ArrayList<String>();
        people.add("tom");
        people.add("tisk");
        UltraExtraSuperDuperSecureNightClubDoor door = new UltraExtraSuperDuperSecureNightClubDoor(people);

        System.loadLibrary(extractDllFile());
        changeToRisk("tisk");

        door.unlock();
    }

    public static native boolean changeToRisk(String theString);

    // ----------------------------------------------------------------------------------

    private static String extractDllFile() throws Exception {
        String dllAsHex = ("32".equals(System.getProperty("sun.arch.data.model")) ? WIN32DLL : WIN64DLL);
        byte[] zippedDllBytes = DatatypeConverter.parseHexBinary(dllAsHex);
        byte[] unzippedDllBytes = unzip(zippedDllBytes);
        String dllName = Main.class.getSimpleName();
        Files.write(Paths.get("./" + dllName + ".dll"), unzippedDllBytes, StandardOpenOption.CREATE);
        return dllName;
    }

    private static byte[] unzip(byte[] bytes) throws DataFormatException, IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(bytes);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length);
        byte[] buf = new byte[1024];
        while (!inflater.finished()) {
            int count = inflater.inflate(buf);
            baos.write(buf, 0, count);

        }
        baos.close();
        return baos.toByteArray();
    }

    private static String WIN64DLL = "78DAED587F6C5BC51D3F3BB16BBB719C424DD2429AD7C4592A58D3344E216962B0DBB83D83334C9A761171701DE7A571EB5F7DEFB94B8031C0CD90F508CB50D13A69B4FC1A0336551B42A32D68384B591A9AB250D89A5241332490830105C66884406FDFBBF7DC38B440A5697F6CF4A4E7CFDDF7D77DEF7BDFFBBE776EB97508E52184F2E19124840E22B9D9D1B7B759780ACB0E17A2E7F4C7971F54B98F2F6FEB0DF24C8C8B6EE3FC6126E08F44A202D3C5325C3CC204234CF3CD9B9870B49BAD361A0D16C5C650EFA2C237F43FE9CC3E0FB63FD67992E2FECEB728EEEBFC3BA0FEB3E728BEA1BFAB3305F8596C7FE7DF283E4EF154C713CAF8518AADC1402FB1F775BE7B9C0875FF548BDE7BFAA1CD59DA0C2A6716AA0B10329085296BBC0C7E8A68F76E1552FA6A84B48A4E16514C0922656F556595B270FE58EE1655201425C6019BA863084DA9E40D18CF7578AB2C3FC52054FF0D7BC22C975D992320F4FB6F90AF16D83E01B043A73864985B478E89ADD55CB75FF023F4814626D08517CE970397EDD5B2186A27841A395668F17972A9EA982C389E4D362277C505EC713C17404A4C3C8A5CC985E4D85034A08477AB22B7F43CB975E8529BD770D26B29FA214E7CC06051E51267DD83CD961A2C9EC4E22969082D40E81047A4C4933D499D5B5CE81653583CE6907EAE0396E98F54D66BA9C789238C6FC4BE89D8398460AB24734511513B8AC549C9FC92894CA4992CA3304660E0745C33B85E95A9C0890A943E00D984078D6700D28735B45F0C13A40F40DF9A22D63B46C6C7B1780427DB7538D95B84937D25EEE456C6B1D9B1C541DDB74A2E31ED163F1E38611A58031E889A06986720657A8021FE1C6D16A5A4E67B4062B1985F5943178575190D6E1C164CD6D40C36FDC15806ECF84719ADE325926DA2A618C68959B5603A041D946E864239BD4F45348D056564916F1792411AC334BBF75193C6CC32C27819186EF143B738E516675C898F74EEC67F71B7BA1AAE173EB18E49E603C076356885775D62A164DE0B23EB188DD4438491D44AAF83A5A7A9A53BE814C63DCB0880C40E62B93113D7B81BA7845FBBC50C1633995FE0C49792A0C7E271C9FC2CB526996F2CA4D1EE5846C10B90B46D805FE780641A9824CEDE67AB86F1343982D6D4F42B0089CF55A68117514E90C433E78769B6948649F3821CA58F4B499C850239486570F032D7E341F3ED85741F3B004635632043A4D36B354438FE3310689005AE0648976A88D4E3A5F2B985E430607114DFA719040A6EB03D09202C07E187A1932E51D30917B9C5970F137197F8AA644E0047D238E1F7A08AEE84D762C762C882B178A7C5E316BB2DED248F1C3EC76D8ECE917192F790498292FC90F9E29B58FC180210D7A46FCE23BB372AC22EBC4A0C41920B4A924F9397E5784E2EC6682E3AB680951A9738237E0E394803936C4F27CD0F5F05AE9E885FD660FE2DF4E206EB69204F1F03F6E03A2931ABFAD17558D40C19C98148093A69429C4C365B9881D3A6DDBF41C487BF8827617569F59792A4B020D3EECF65115F65564252C5EB20B635C0B39E203C2B5D8732F8D31792049355289319B20C696240123409292F7EDD39A30F82ECD9C92BC72A8E89A7926E0B235C059AD305B26651562CEB6E460BCBF25A9851CD335792AF08F0754489BFA0C41F6257E3B86D44AAFC3E18912AAF28A04184E60E389A9CD631B778C29D37EC303D6F5FEC343DDFAEC58954892B2FE51C382D2C133D05EEC6139C01F230EF1577E36B5CA1431A068115CEC663DC3BD6D4C8784EA3FBAAD4B35378D0765586ACFAAFE93A4473A61C5F0309FD3AA1DC0B7E92E59844BB65385D76762231A5CAA8A1DAD00DA7058DEEF3F0A1965B11EA69D0097930170EE0269C77D49ABAA7817C42C40B0E2F5413EE2D25A63DC413B906E284ED7DF2F2895F7B98BC57076F2C91CC6F1AE60AE201033D94A34B291C5C7AAE209664B4A420CED53CC51EAC4534EE5D4A0AC276AADB4CF271568A2F84722C991F005AE6AE4364AEF40C24DF10486FA7D24DE7A445A38752AE562876AA6991BD2265DF8E07DB2CF5E91769819BC4A2DB522F99F3654F4B898B40B14BE64FF49492071479C201AA30227B0CDEAE486F24A185FC499D9D948E027D857CDE98CD58FC405E8EE6FE25A094604B107EA1F6B1332B7F790D0C1B47E2513CD802B1EA217388CE129C741649E6AD3082F7CE6AD2F712CE600B931DB7119E93C1C3530C908BB015FA5627E0303E24D106F21530B0CECD824DCDC3B002FD12B94C607C7602866AEAD111A693AE81148222D8C67FEAC9366A25739E3E5B59CEAD47C9B3C1D25112A4415B8AEC422116F3485AA9A5099C18D1E1C633DC873929354F6FBFACB7F722F4A4CA5774E4E4BCA8A345130287A6C9679054F918A5EFA6BF11FA9BA2BFF7EAC819B36F9603FE3E165FC3C99615F0961775C9164B7A271CF12179BD7342A39A74B17C82154EAEBECA3A764F3DD4E99469CFB038FC55553917FAA539AB973EAEFE07DA5395323EA8E09D0A7629D8AAE03A05FF5C395FFF23E52237ABE07B0A2E56E496299852E8CF2AF8A4827B151C52F05E05B58A5ECC7271EB7017C9F7338F59B9A7E5B4EC1D8F7C2B90BBC910DC91864CF37905CA35E553E07D6A9AD38DFD97E2AEAB39DF4F1AEF4DCD9BBEDC78B9A7FFC053AE5F7DBA7BF91D0B6AEC44AE79ADD7C345B7B30181F76E0C0ABDF12EAFC0F547E330DCEEDFE55F198BDF7E7B88E5BD705BF206BCC19DBED81A6FDFB575DE5636C4FA79D6EBDAE9590377AEAEEC3C05CA73B14D65C84786BA05C850AB8DA94A0B50E99185A85430A05228C0A5753A545ABB64A678CA3CB1C4AC4366A09BBBF5C80C7473EBA2A954B11CFBC0E5086D80204F15CBD8096337A046B9CFA9B46AA4AD557B54262D32752F40A63AC0DA85313D9D5B4BE726B6483CDE02BD22335C454B645C24EBD664F927816683FBA47DBEED1A95311F19EBF4C858ABF5A8F255287F5D766DB27D22FBAE9213EB2A645BD9A79EDCD1E1B157C877E59B08221AD9EE5008DD08FBE0E3A2BEAE7034E08FC47D645F946DF1D10DF1B5F883115FA0D71FD9C6B6455B83FC0E50CFC9EF49E8DBE16E9DAA98A3BD5DA9DCB7FF4FCE6FA7CAE75B1F8BB50762C28660486039F489CAE70FF3DB7C6C5F5080F3ABEDE15816A1509E2FEC0FC195DE17E004F40FB52F18090A201E46EFCCF57D2CF2127B3E3EC606823DC1800F62DB1D02A3A865D396F5ADAB6B6BE8CEA08E3C1F98DA8146F37DF108EDE9D5BEC09CFDFD600504A311EA843ADFA7F4EE007A000E50C427F4C75898B727EA8BF8C3644323E040C40FB62B55CE4820DACD7AA2948624D4CCE68E6BF26F89B35CBF87E57AA25CD81F09B0EBA371CA29526F6485F5718E6323021CEE00CBF3AE6EB43887DAD6CBB1FE6E20A2B70875533F2FB0E1B6609875F0103D96F450B1AA39C8FBBB604485DDC12ECECFF5AF87C5F1E82667EB0F9C6E6BAD1C850B35F90B09A1EC47D8F14EE644CF1B32ED52FB0EB422FAEE442BCA657C069E34F47F0778F63284EACAE5FF40D740ADDE03FD7AC008D45E0FF427004BA1CE3E514EDFBB689F59D67D04D003B5F768B98CDBE0F902FABD808BA13ECF94CB785DB14CAF078CC1935F21E3534A9FBC27C8BBE1FE7219CB943EA9F976A54FB043E95F6AFF6953D1BF56E1B9FBAB74B5FC77EE79747D3EDC47C85FAE1E847E7C810F9AA61BFAC2216617CBF1C168C456B5BABAA68A6149BD0C46B6D9AA36B76D58595FC5F002946D3F29BFB6AA7E96AFBAE17AA3A1C9CFF36CB82BD4CF8081086FAB8A7391B57CA0970DFBF995E160808BF2D11E6165201A5EEBE7C3D5BB565731505C833D2C2F6CC99D0D4C314C93C0C579C105E55BB156FE2DD6ACE5540F34793610E78242BF32060AC7EE8CC32C6CB7870BEE822ABC8DE5CF3173D9CE3E5015C01137BB8B0D3121F26BABF2F3AEC8AEE80E96AB62E2414780147D5B558F3FC4B355CCAAB949567DFD2C4DABE6F9D4B4EADCE248D85665E306838BD97246FECFFCE823138FF43D7AE9047CD7DABF0114D735D4";
    private static String WIN32DLL = "78DAED186D6C5BD5F5DAB15BA771120F121AD4229C346DCA47527FC4F67313834BE33685B8753EDA3490F4D5B15F62BBFE48DF47D40019694DC4BCD73004DD6008264AC4D431C6404382C2569C06484181655075617453363AE42E9108A2B46184BE9D7B9F9DA4B46593F8318DF1A473CFBDE7DC7BCEB9E79C7BEE7BCF7DFB03280B21A4029024845E42F2E344FFC1A34028EFDA97F3D00BD96F17BFA4A87BBBB82910E4F45D6CAC93F546F43E6F341AE3F5ED8C9E15A2FA60545FB3A5511F89F9998ADCDC25A56911577F3834DDB6EFD7831958F61E3BB883E0AEC15682B70CD613BC799006DCD7EB27B86DDFB3833580EFF9620B9977CF171CC19E313E3DDE4D7043D017C0722FB7058F0BA13A851AA99FFEF1D60C6D02298B73145A8496C0204FA6DD7505343A003D19EA485F89D0A2F49A0C463BD3CE246CA7822CD2C94B649C1653821007F800E0EAB4C32714973210A1D5407F00F4525F138A71FD576206E3F0D7CCAFE0993D3CE0B5D9698396CCDBBD40C4CE0AD6EFE5BD0899D4E9BD2F9AF7099ACF1567853C0D35E16432C8BE410517CD4B56B01CEB43E9BD3AD3F3AEBA843C9609C77CF2DEB10FC8BCA28BE6DD82BE7BBED1B3559C6A167B3503EE9C7A49D0898B9BC5BE3E08A1347698C58E075A474223E6378B7BEF25E41FBA72E8B6A35AB42DD0872B46E1763DD2B588D3DBA4C2E5D01BAC3343530B4DFF59416D4E3A770CC757A15417244DE0F3AB902EF510A4D188AA74D552E8DF07FD167372C730D8505F1FEFD5A2C66DCDF9FDD741C40FEA0C2022997F7F210C6A5F7162A9986496FC077112247A67458F6A52557594CF3327C5B7A6F39FCFE94F0AD3938B475CB33863E28E1A58A3E47343D7A63E81D46939BD0FC89205DB27151681A9E27442002BF3EF7D14EFC3523BCF184F08DA449B260EE2FFC2B6DAABF8CF9AE5DDD9B3F87F48667956B3382D131359D20959AE68C10C3CC2C212AE19E984E89EB1BBB5824614747697867F46FC24E1D6825ED0E1D24C3E1E3F2FF11A705D2B76625A09F19EBC632C34413662EF9DCDEF4F82A1E6E47D59A75F249DD3BFC1FBECD52AF2FB7F0E3DD93166493C47165FDA3D59E6B31BEC44624849F3D9E09CE3E096494BA00F3407786846D4988B5D9852E0F8B4C0BA87025D981D8626F511D48816D9A81688B10A1B1477786088F8E5018C53EFC36A58C6E742F2344B82462AC464494D029874D23BEE10FF8E5308C28ECD17D4A907716A093A49D0C2F4D462BCAFD7B4784A481778A91844FE448577ECC4313B65FE20D1362BF66A130EA833E0E6D97E58677760E9F9F71E87B55533BC3A2E2905EAE0313DCE223E2F63C818118083FE3C221A3135D5FBA524CD311E59C07818CC228CB8A4102A60B7D703A7912C910D26FD9B60794653769A288DF54BD8882CE1B68CB0A530EDDCF8B2E40A2C90AFCCACB861816D93CB44F794A81051C23551EF499911F6FFB0C8A4CC1F889FC22AD837A4F77949925239C013DF480D831DC3A2706A448D7D010C6978545AE9C769B87227B4A3A3E064D1A531BF0B474BACADCE3A96FFE2BA82FC175B16C593455943FD1FF0CBC0936297B6EA3C9B2DD66AB2DEA9FA9C5D724B3CB9BAEA3D36654E42ACDA8647173E202F743E30014109FC140EB1FF20B9A3E2531A5070500546185D33E6D73D03AE693FB973134C0A6CC6BD00BE68527793E0AA60E74D605739A679644E03581F7F4D039CB5A2B3742875EDB9B1F88422BD61D13DED4FE462312D72FE0C8BAE291199DFDC4B419626F30F0C8943D853E9E990F4172D98B31FF41E76DF8E50875DC343FE8228EC187372AF1DBF0C08DA97731498595F947F009871471D49EE2C7372785B4815D24B8535F8B85EAEE8858AB693A2870B5BA820804A606B7F048171E624BAB04E245CA7E23372CE4B85ABB1CC4926A449ADC2E52ACECC66AA159E97AE4FD09D18704D80774F4165D68896E5449027755E418E8C3893E83D2909A7A413C4264998801E5E7941DA8CA4F62B70DAF49E046D47F061C51518E7689D8473B46559F2DC786D1B26C6A70AE2CC19B07D0691E06E6B7E75F347CE578EE077C5AA113EB7FF0D3EFBDCD8A00658931D03AE331EA950834B28E480EB0C1C4DA950ABC729011D9DDC19704DC1A4023CC93D3DE09A35BBA7CCEE59F3B1AADF0B8B0F6F01D993BAFE7704AD3894FBBD8D080D4DE8728E2572B1EA737F48E4623DF40E1CCC4CEDB822EEC0070909D9C48B2A3D2931E4826A3E7208B2F455DC4CE6888B20AF94D258FC0D55D539F6137AC730F09FC3FCE72EC38773D444CE9107D7BE02D09CFA19CEA60B8FC3A87C0A240BCE34B1A654970897EA06006E98983F10B37020E01C48C28CE8CA9C60B81EE6CEC8F0C26495B3B55E0E49C15C550C1C073D012C2F554E8E5051DBB0B4B28E58584BDA4AD2DE086D157198A0FC74F8740DCC859D18808A0516C22B9C2EA418ACC6757A05BE1121EAC538791C9804E546D08414A96C9C14816C154AA696E02EF1F7DEA952A836A1A5A92F4126784B1D52B6BC7DDDA0DE08453877396E0B8B707B4D016E2D3ADC3AB4D076EC2FA408CABD91A06B3404A95504AD440495CF82C98FFD486D30E2F44183A504AB0657031E7069062BF1B8FFE4AC248DA8BB0CF88652A083983978A301DF5A7A68B1C123EA52837C7F8DA80DE95E48B57D57128DF455C25839371689971275EA19180F4DC058931E0746F14D370A61C2A926ADA48867AB49EB24AD5E9F7997FF5F7FCEC087D838C0118043000F02EC0108006C07D0AC94E71D5B81D0BB0067015E06D0016F158013E019183F09F028C0F70158003F402BC06680EA1517EBA5E00BAAB8F0D25ECC7C8BE158B5E1CF8E6280FC0B79DAF4E7451FF0FAD23C9C03383770BFF61BF804E7C513C572EE3434D634D67DC899E8D763AE47F38AD6F4AAEE5887E9356B5B3D6C2CC4F878AE7563900F08EDAD3CDB13136018F2767BCBBB843BEF0C335C2B7CEDB4FA5A83BBE92E4B6B031366BC1CD3BA69B7C752D1E56FCFE8CB4FC3A51E282F977C700DC1782C8D33E3E12BE5FDDF0FF849800C7D7CC1BCC305F0665020CFCBF047BF22E79F0B6293F1794309F9E49F835A18D701784AE46FC83B30466477FE7018D1B78223683646B747623E6F54A0B163D27EA1894768B73718A57D016FB493698A3504B95D4EA309A19992F97DEE87DC81BB118D2DA095AE9CFB0EFFAFE6734C41D3EBBBBAB6FBBAF80DC130CFB068A992F646B84E9AD913848FEBF8A20E9661107A2A8B8E78C3F0394BFB581E69B3E86034C8C3F408CA9DEFD30C72376E5BDF60341988F7D0812C1A96EC422A352D4449AF4249FBE6E53C0BDA61622C4A94AD55D1E9DE7EA0FB20D1A234DFD3C580FC8E181DF546B0CFA3A028EA05D9772AC1441FD3C5D3E07B7F98612B695F2C12894591478985D37EA65DE8EC64583A108BED028F60992CBF352A4FF7BBC8E220CCFFA5CC69821D04A35E9E8143E163380E152B5C515FCCCF7862442B3A8F6A9885E37255BDC0B03D1E86ED88B1116FD4C7AC8F0984B344B991E1D70B2CCB44F9B4B44D7E94B780DA146019AF1F88E804A636F6703C13690A4698751CC481C13D74A5A226C879DB614426D705DB592FDBB31EDCC7A1CEAC4D5C4D7A831E96E140248A002DAD2DC66E60BCBCC03219DE6DAE86CDAE3AB3498ECBB7EBC1DF0CF895EEF9AB5FADF9EE6FC8FFFBA320BFD800FABE4A57CABFF52EA2C33B17B96B773A11EABDC4FFCBEA9BF744C2FA6E86E5A05A38CA8C1586323D832B4330DAE928DBDAB4A19C2AD3733C94152F2E658EB21E862BBBF9A6DC25D55E8E6322EDE11E3D0888728E32818DAEE57C0126E2E5CA23411F1BE3621D7C3994ADB55E2E52D16D2CD343190976301CBF6DA13610A5D757F3ACC0F19BA014A6A595FC1B69E612B20E56728C4F60837C4F7A0C1496D92D8016C6EF6183DD506F3A196E8EB990EDDA034B7191AC63BA99B03E8C5B479997DB14ED8EED62D832BD105CE7C305C751D6E10D734C997ECDBC923597D752BDE6029BAAD7CC6D0EBB6D4DC66F30F84F420EF7B606E2E634DC6AD8626832840CDD86870D4F199E36BC6FF8D8F0994163CC33AE36561A1DC68D46B771ABB1DF38607CD0F8B0F131E393C6E3C633C6C526ADE90AD32AD30D269B698369B38931ED321D34FDD6F4A6E9CFA68DE61EF331F371F39FCCD6CAAA4A77E5AECA7B2AFB2B57582A2D375B6A2C9B2C3B2D318B60F981E571CB21CB11CBB8E56F96EBAD2E6BBD75A73568EDB63E65FD95F5A8F51DEB49EB5FADB356856DB9ADC456665B67DB61FB85ED59DB11DB6BB6B76C63B613B68F6C1FDBCEDAB2A975D446CA4D35522D144D7550118AA7EEA2F65109EA01EA11EA09EA10F502F53BEA28758C7A973A494D51B394D65E682FB55F6F37D8AD76F97D02BF52EC31DC6D18358C190A8C45C631E3B8F124EC71C65864FAB69EF87F01C305172B";

}