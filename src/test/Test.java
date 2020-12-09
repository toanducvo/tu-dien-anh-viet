package test;

import dict.*;

public class Test {
    public static void main(String[] args) {
        try {
            AVLTree tree = new AVLTree();
            tree.add("aboil", "Tính từ & phó từ  $đang sôi");
            tree.add("unclick", "Ngoại động từ  $(kỹ thuật) thả ngàm hãm (bánh xe răng cưa)");
            tree.add("uncleanliness","Danh từ  $sự bẩn thỉu, sự nhơ nhuốc");
            tree.add("consubstantiality", "Danh từ  $tính đồng thể chất");
            tree.add("abrogative","Tính từ  $bị hủy bỏ");
            tree.add("soilure", "Danh từ  $vết nhơ");
            tree.add("clearway", "Danh từ  $đường cấm xe đỗ");
            tree.add("westland", "Danh từ  $đất miền tây");
            tree.add("absquatulate", "Nội động từ  $trốn chạy");
            tree.add("foxship", "Danh từ  $tính gian xảo");
            tree.add("acescent", "Tính từ  $hoá chua; chua");
            tree.add("whity", "Tính từ  $trắng nhạt");
            tree.add("worldwide", "Tính từ, Phó từ  $khắp thế giới");
            tree.add("dotted", "|Tính từ  $có nhiều chấm");
            tree.add("otherwhile", "phó từ  $vào lúc khác");
            tree.add("whilere", "Phó từ  $(cổ) cách đây không lâu; mới đây");
            tree.add("patagial", "Tính từ  $(động vật học) thuộc mảng dù lượn");
            tree.add("crumpy", "Tính từ  $dễ vỡ; mềm yếu");
            tree.add("outclimb", "Ngoại động từ  $trèo giỏi hơn");
            tree.add("downland", "Danh từ  $vùng đất thấp");
            tree.add("zoo", "Danh từ  $vườn thú; sở thú");
            tree.add("uncheerful", "Tính từ  $không vui; buồn; rầu rĩ");
            tree.add("passiontide", "Danh từ  $hai tuần lễ cuối của tuần chay");
            tree.add("zipper", "danh từ  $khoá kéo (ở áo...)");
            tree.add("pauperize", "Ngoại động từ  $bần cùng hoá");
            tree.add("pawnshop", "Danh từ  $tiệm cầm đồ");
            tree.add("hunkers", "Danh từ  (số nhiều) (khẩu ngữ) $hông");
            tree.add("outborn", "Tính từ  $sinh ở nước ngoài");
            tree.add("semimetal", "Tính từ  $nửa kim loại");
            tree.add("semisweet", "Tính từ  $ngọt vừa");
            tree.add("unbreathable", "Tính từ  $không thở được");
            tree.add("farmland","Danh từ  $đất chăn nuôi, trồng trọt");
            tree.add("softy", "Danh từ  $(thông tục) người nhu nhược, người ẻo lả");
            tree.add("crutched", "Tính từ  $đi nạng; chống gậy");
            tree.add("contractibility", "Danh từ  $tính có thể thu nhỏ, tính có thể co lại");
            tree.add("cryolite", "Danh từ  $(khoáng chất) criôlit");
            tree.add("cryptologist", "Danh từ  $người chuyên về mật mã");
            tree.add("hybris", "Danh từ  $quá kiêu căng");
            tree.add("unbesseming", "Tính từ  $không thích hợp");
            tree.add("bedtime", "Danh từ  $giờ đi ngủ");
            tree.add("well-balanced", "Tính từ  $có tinh thần ổn định");
            tree.add("ctenosome", "Danh từ  $(sinh học) nhiễm sắc thể hình lược");
            tree.add("oubliette","Danh từ  (cũ) $hầm ngục tối");
            tree.add("magnetostatics","Danh từ  $từ tĩnh học");
            tree.add("solute", "Danh từ  $chất tan");
            tree.add("bill", "Danh từ  $(từ Mỹ check) hóa đơn, giấy tính tiền $tờ quảng cáo, yết thị");
            tree.add("maharaja", "Danh từ  $hoàng tử (ấn Độ)");
            tree.add("encephalisation", "Danh từ  $sự hình thành bộ não");
            tree.add("uncompliant", "Tính từ  $không hay chiều  $không phục tùng");
            tree.add("employable", "Tính từ  $có thể được thuê làm");
            tree.add("employee", "Danh từ  $người làm, người làm công");
            tree.add("employer", "Danh từ  $ông chủ");
            tree.add("well-made", "Tính từ  $phát triển cân đối (người)");
            tree.add("uncap", "Ngoại động từ  $bỏ mũ (để chào) $mở nắp");
            tree.add("housewifely", "Tính từ  $nội trợ");
            tree.add("hurdler", "Danh từ  $vận động viên chạy vượt rào");
            tree.add("hurdling", "Danh từ  $môn chạy/nhảy vượt rào");
            tree.add("hurds", "Danh từ, (như)  $bã đay gai");
            tree.add("hygrograph", "Danh từ  $máy ghi độ ẩm không khí");
            
            System.out.print(tree.search("hunkers"));
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
