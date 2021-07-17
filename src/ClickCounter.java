/**
 * オブジェクト指向プログラミングおよび演習 第13回
 * 課題1
 *
 * 9つのラベルでクリックした回数を表示するプログラムを作成せよ
 *
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

/**
 * メインクラス
 */
public class ClickCounter extends JFrame {

    /*---フィールド---*/
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JLabel label1;
    private JLabel label3;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JPanel parentPanel;

    /*---コンストラクタ---*/
    /**
     * デフォルトコンストラクタ
     */
    public ClickCounter() {

        // パネルとラベルを配列にする
        List<JPanel> panels = new ArrayList<>(Arrays.asList(panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9));
        List<JLabel> labels = new ArrayList<>(Arrays.asList(label1, label2, label3, label4, label5, label6, label7, label8, label9));

        // パネルとラベルのペアの配列を生成する
        List<PanelLabelPair> pairs = new ArrayList<>();
        for (int i = 0;i < 9;i += 1) {
            pairs.add(new PanelLabelPair(panels.get(i), labels.get(i)));
        }

        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの設定
        setBounds(100, 100, 350, 350);

        // コンテンツパネル設定
        setContentPane(parentPanel);

        for (PanelLabelPair pair : pairs) {
            // ラベルを"0"で初期化
            pair.getLabel().setText("0");

            // クリックイベントの登録
            pair.getPanel().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);

                    pair.getLabel().setText(Integer.toString(Integer.parseInt(pair.getLabel().getText()) + 1));
                }
            });
        }
    }

    /*---メソッド---*/
    /**
     * メインメソッド
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> { new ClickCounter().setVisible(true); });
    }
}
