public class PttMessages {
  
  public static void main(String[] args) throws InterruptedException {
    
    String messages[] = {
        "�� bluewinds:�ڦb����}�h�����J����Q�s �M�o���P����~�d��̫� ��   11/02 21:11",
        "�� FackPtt:  �N�g�X�ӤF                                                                              11/02 21:12",
        "�� bluewinds:�̳��b�ݦo �S���Hť�ѻ��H������~~�o���H�H�W�n~~�@ť  11/02 21:12",
        "�� ZBeta:    �N�g�X�ӤF                                                                              11/02 21:13",
        "�� bluewinds:��ڭ̬O�x�W�Ӫ� �N�ܶ}�ߪ��M�ڭ̦X��~~��ӥh�Z�ҤS  11/02 21:12",
        "�� sephen:   �g�X�ӤF                                                                                  11/02 21:13"
    };
    
    for (int i = 0;i < messages.length;i++) {
      System.out.println(messages[i]);
      Thread.sleep(3000); // �Ȱ�3��
    }
    
  }
}