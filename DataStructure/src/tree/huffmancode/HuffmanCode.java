package tree.huffmancode;

import java.util.*;

public class HuffmanCode {
    //生成哈夫曼编码
    static StringBuilder stringBuilder = new StringBuilder();
    static HashMap<Byte, String> huffmanCodes = new HashMap<>();

    public static void main(String args[]) {
        String str = "You're uinique, nothing can replace you.";
//        String str = "i like like like java do you like a java";
        /**byte strByte[] = str.getBytes();
         //        System.out.println(getNode(strByte));
         Node root = creatHuffmantree(getNode(strByte));
         //        System.out.println(creatHuffmantree(getNode(strByte)));
         //        root.preOrder();

         getCode(root);
         System.out.println("生成的哈夫曼编码" + huffmanCodes);
         System.out.println(Arrays.toString(zip(strByte, huffmanCodes)));**/
//        System.out.println(Arrays.toString(huffumanZip(str)));
        byte[] bytes = huffumanZip(str);
//        System.out.println(Arrays.toString(decode(huffmanCodes, bytes)));
        System.out.println(new String(decode(huffmanCodes, bytes)));
    }

    public static byte[] huffumanZip(String str) {
        byte strByte[] = str.getBytes();
        Node root = creatHuffmantree(getNode(strByte));
        getCode(root);
        return zip(strByte, huffmanCodes);
    }


    //生成哈夫曼树
    public static Node creatHuffmantree(List<Node> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
//            System.out.println(list);
        }
        return list.get(0);
    }

    public static void getCode(Node root) {
        if (root == null) {
            System.out.println("树为null");
            return;
        }
        getCode(root, "", stringBuilder);
    }

    public static byte[] zip(byte b[], Map<Byte, String> map) {
//        将哈夫曼编码转成字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte bytes : b) {
            stringBuilder.append(map.get(bytes));
        }
//        将字符串转成byte[]
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte by[] = new byte[len];//创建存储压缩后的数组
        int count = 0;//记录是第几个
        for (int i = 0; i < stringBuilder.length(); i = i + 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够八位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            by[count] = (byte) Integer.parseInt(strByte, 2);
            count++;
        }
        return by;
    }

    /**
     * @param node          传入节点
     * @param code          路径：左子节点是0，右子节点是1
     * @param stringBuilder 用于拼接
     */
    public static void getCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data == null) {//是非叶子节点
//向左递归
                getCode(node.left, "0", stringBuilder1);
//                向右递归
                getCode(node.right, "1", stringBuilder1);
            } else {//说明是叶子节点
//表示找到叶子节点的最后
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }

    public static List<Node> getNode(byte bytes[]) {
        List<Node> list = new ArrayList<>();
        HashMap<Byte, Integer> hashMap = new HashMap<>();
//        统计字符数目
        for (byte b : bytes) {
            Integer count = hashMap.get(b);
            if (count == null) {
                hashMap.put(b, 1);
            } else {
                hashMap.put(b, count + 1);
            }
        }
//构建node
        for (Map.Entry<Byte, Integer> entry : hashMap.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    //    数据解压
//    将byte转成二进制字符串
    public static String byteToBitString(boolean flag, byte b) {
//用一个变量保存b
        int temp = b;
        if (flag) {
            temp = temp | 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //    解码
    public static byte[] decode(HashMap<Byte, String> map, byte[] b) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            byte bytes = b[i];
//            判断是不是最后一个字节
            boolean flag = (i == b.length - 1);
            stringBuilder.append(byteToBitString(!flag, bytes));
        }
        System.out.println(stringBuilder.toString());

//        反向查询字符
        HashMap<String, Byte> hashMap = new HashMap<>();
        for (HashMap.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
//        创建集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte bs = null;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                bs = hashMap.get(key);
                if (bs == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(bs);
            i += count;
        }
//        结束循环，存入byte数组
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "data=" + data + " weight=" + weight + " ";
    }

    @Override
    public int compareTo(Node o) {
//        表示从小到大进行排序
        return this.weight - o.weight;
    }

    //    前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}