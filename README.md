# AtOfferInJava
剑指offer中面试题的完整Java语言实现

### 面试题1 赋值运算符函数
该题目涉及到c++语言的指针特性，java语言暂没想出解决方案。

### 面试题2 实现Singleton模式
>设计一个类，我们只能生成该类的一个实例。

##### 实现代码

```
 public class LazyLoadedSingleton{
        private LazyLoadedSingleton{} //private构造方法，防止外部实例化该类
        private static class LazyHolder{  //静态私有内部类
            private static final LazyLoadedSingleton instance=new LazyLoadedSingleton();  //静态final实例
        }
        public static LazyLoadedSingleton getInstance(){
            return LazyHolder.instance;
        }

    }
```

##### 算法描述
上述方式使用了延迟加载，使得应用的性能得到提升。同时，使用静态私有内部类，使得该方式是线程安全的。    
更加详细的信息可以参见博客《 [Java设计模式之Singleton——四种不同的单例模式（Singleton）](http://blog.csdn.net/zhoucheng05_13/article/details/78331699)》。里面由简到繁地介绍了四种单例模式，对于性能和多线程安全因素均有考虑。

### 面试题3 数组中重复的数组
>在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。

##### 测试用例  

- 长度为n的数组里面包括一个或多个重复的数字
- 数组中不包括重复的数字
- 无效输入的测试用例（数组为空，数字不在0~n-1范围内）

##### 实现代码

```
 /**
     * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     * 。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
     * @param array 查找的数组
     * @return 重复值或者-1（异常）
     */
    public static int duplicate(int[] array){
        //安全验证部分
        if (array == null || array.length <= 0 )
            return -1;
        for (int i=0;i<array.length;i++){
            if (array[i] < 0 || array[i]>array.length -1)
                return -2;
        }

        //算法实现部分
        for (int i=0;i<array.length;i++){
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    return array[i];
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
       return -1;
    }

    /**
     * 测试例程
     * @param args 0
     */
    public static void main(String[] args) {
        int[] array = {2,3,1,0,3,5,2};
        int dup = duplicate(array);
        if (dup == -1)
            System.out.println("不存在重复数字");
        else if (dup == -2)
            System.out.println("输入的数组不符合条件");
        else
            System.out.println("重复数字是："+dup);
    }
```

##### 算法思路
从头到尾依次扫描这个数组中的每个数字。当扫描到下标为i的数字m时，首先比较m是不是等于i。如果是，则接着扫描下一个数字。如果不是，则比较m与下标为m的数字，如果相等，那么m是重复的数字；如果不等，则交换下标为i和m的数字，将m放回合适的位置。接下来重复这个比较、交换的过程，知道我们发现一个重复的数字为止。虽然算法中有双重循环，但是第二层循环最多进行两次，因此总的时间复杂度为O(n)。同时，由于所有操作都在本数组中进行，因此空间复杂度为O(1)。

### 面试题4 二维数组中的查找
>在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

##### 测试用例

- 数组包含指定数字
- 数组不包含指定数字
- 数组不符合要求（数组为空）

##### 实现代码
```
/**
     *在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param array 数组
     * @param num 要查找的数字
     * @return 找到：true 找不到：false 
     */
    public static boolean findNumber(int[][] array, int num){
        //安全验证部分
        if (array == null)
            return false;
        //算法部分
        int i=0;
        int j=array[0].length -1;
        while (i <array.length && j >=0) {
            if (num == array[i][j])
                return true;
            else if (num < array[i][j])
                j--;
            else
                i++;
        }
        return false;
    }

 public static void main(String[] args) {
        int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findNumber(arr,7));
    }

```


##### 算法思路
首选选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；如果该数字大于要查找的数字，则剔除这个数字所在的列；如果该数字小于要查找的的数字，则剔除这个数字所在的行。这样每一步都能缩小范围。

### 面试题5 替换空格
>请实现一个函数，把字符串中的每个空格替换成%20.例如，输入“We are happy.”，则输出“we%20are%20happy.”。

##### 测试用例
- 输入字符串包含空格
- 输入字符串不包含空格
- 特殊输入测试（字符串为空；字符串是一个空字符串；字符串中有连续多个空格）

##### 实现代码
```
/**
     * 替换字符串中的空格
     * @param str 字符串
     * @return 替换后的字符串
     */
    public static char[] replaceSpace(String str){
        if(str == null || str.length() == 0)
            return null;

        int spCount=0;
        int i,j;
        char[] chars = str.toCharArray();
        //计算空格的个数
        for (char aChar : chars) {
            if (aChar == ' ')
                spCount++;
        }
        //发现一个新的空格，新数组的长度就要加2
        char[] newChars = new char[chars.length+2*spCount];

        i=chars.length-1;
        j=newChars.length-1;
        //处理原始字符串中第一个空格及之后的字符
        while (i != j) {
            while (chars[i] != ' ') {
                newChars[j--] = chars[i--];
            }
            newChars[j--] = '0';
            newChars[j--] = '2';
            newChars[j--] = '%';
            //处理完成，跳过空格
            i--;
        }
        //将第一个空格前的字符复制到新字符数组中去
        for (int m=i;m>=0;m--){
            newChars[m] = chars[m];
        }
        return newChars;
    }

    public static void main(String[] args) {
        String s0 = "we are happy.";
        char[] s1 = replaceSpace(s0);
        System.out.println(new String(s1));
        //不能使用如下方式打印字符数组
        //System.out.println(s1.toString());
        /*用System.out.print()显示某个对象时，会调用该对象的toString()方法，对于数组也一样。
        而对于数组，调用toString()的默认实现是打印对象类型+hashCode()
         */

    }
```

##### 算法思路
从前往后复制会导致O(n<sup>2</sup>)的时间开销，而计算好空间，从后往前复制则只需O(n)的时间开销。  
先遍历一遍数组，计算出空格的个数。创建一个新数组，大小是原来数组大小再加上空格个数乘以2.声明两个下标，分别指向新旧数组的末尾，依次复制，遇到空格则处理空格。

### 面试题6 从尾到头打印链表
>输入一个链表的头节点，从尾到头反过来打印出每个节点的值。链表节点定义如下:

```
    class ListNode{
        int m_nKey;
        ListNode m_pNext;
    }
```

##### 测试用例
- 功能测试（输入的链表有多个节点；输入的链表只有一个节点）
- 特殊输入测试（输入的链表头节点为空）

##### 实现代码
```
/**
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值。链表节点定义如下:
 */
public class InterQuestions6 {
    /**
     * 链表节点内
     */
    static class ListNode{
        int m_nKey;
        ListNode m_pNext;
    }

    /**
     * 逆序输出链表方式一：使用java的栈
     * @param list 需要逆序输出的链表
     */
    public static  void reverseListWithStack(ListNode list){
        if (list == null)
            return;

        Stack<ListNode> stack = new Stack<>();
        while (list != null){
            stack.push(list);
            list = list.m_pNext;
        }
        while (!stack.empty()){
            System.out.println(stack.pop().m_nKey+"  ");
        }
    }

    /**
     * 逆序输出链表方式二：使用递归.
     * 该方式虽然更加简洁，但是如果链表过长，那么可能会导致调用栈溢出。该方式的鲁棒性不如方式一。
     * @param list 链表
     */
    public static void reverseListWithRecursion(ListNode list){
        if (list == null)
            return;
        
        if (list.m_pNext != null)
            reverseListWithRecursion(list.m_pNext);
            System.out.print(list.m_nKey+"  ");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.m_nKey = 0;
        for (int i=7;i>0;i--){
            ListNode newNode = new ListNode();
            newNode.m_nKey = i;
            newNode.m_pNext = list.m_pNext;
            list.m_pNext = newNode;
        }

        reverseListWithStack(list);
        reverseListWithRecursion(list);
    }

}
```

##### 算法思路
由于需要逆序输出，类似于“先进后出”。实现方式一：考虑到可以使用栈来实现。遍历一遍链表，并把链表中的元素一次压入栈中。最后，依次弹出栈中的元素即可。实现方式二：递归在本质上就是一个栈结构。所以可以使用递归来实现。

### 面试题7 重建二叉树
>输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复数字。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建如下图所示的二叉树并输出它的头节点。二叉树节点定义如下：

```
class BinaryTreeNode{
    int m_nValue;
    BinaryTreeNode m_pLeft;
    BinaryTreeNode m_pRight;
}
```

![tree](http://odwpzo1jp.bkt.clouddn.com/interview/questioins/interview7.png)

##### 测试用例
- 普通二叉树
- 特殊二叉树（所有节点有没有右子节点的二叉树；所有节点都没有左子节点的二叉树；只有一个节点的二叉树；

##### 实现代码
```
/**
 * 二叉树的节点类
 */
class BinaryTreeNode{
    int m_nValue;
    BinaryTreeNode m_pLeft;
    BinaryTreeNode m_pRight;

    public BinaryTreeNode(int m_nValue, BinaryTreeNode m_pLeft, BinaryTreeNode m_pRight) {
        this.m_nValue = m_nValue;
        this.m_pLeft = m_pLeft;
        this.m_pRight = m_pRight;
    }
}

public class InterQuestions7 {

    /**
     * 重建二叉树的外部接口，主函数
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @return 重构的树
     */
    public static BinaryTreeNode rebuildBinaryTree(int[] pre, int[] in){
        /*int root = pre[0];
        for (int i=0;i<in.length;i++){
            if (in[i] == root)
                break;
        }*/
        if (pre == null || in == null)
            return null;

        return rebuildCore(pre,in,0,pre.length-1,0,in.length-1);
    }


    /**
     * 构建二叉树的核心递归方法
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @param preStart 前序序列起点
     * @param preEnd 前序序列终点
     * @param inStart 中序序列起点
     * @param inEnd 中序序列终点
     * @return 当前树的根节点
     */
    public static BinaryTreeNode rebuildCore(int[] pre, int[] in,
                                             int preStart,int preEnd,
                                             int inStart, int inEnd ){
        int rootValue = pre[preStart];
        BinaryTreeNode tree = new BinaryTreeNode(rootValue,null,null);
        if (preStart == preEnd && inStart == inEnd)
            return tree;
        int root =0;
        //查找根节点在中序遍历中的位置
        for (root=inStart;root<=inEnd;root++){
            if (rootValue == in[root])
                break;
        }
        //左右子树的节点个数
        int leftLength = root-inStart;
        int rightLength = inEnd - root;
        if (leftLength > 0)
            tree.m_pLeft=rebuildCore(pre,in,preStart+1,preStart+leftLength,inStart,root-1);
        if (rightLength > 0)
            tree.m_pRight=rebuildCore(pre,in,preStart+leftLength+1,preEnd,root+1,inEnd);
        return tree;
    }

    /**
     * 二叉树的前序遍历
     */
    public static void preTraversalBinTree(BinaryTreeNode tree){
        if (tree == null)
            return;
        System.out.print(tree.m_nValue+",");
        preTraversalBinTree(tree.m_pLeft);
        preTraversalBinTree(tree.m_pRight);
    }

    /**
     * 二叉树的中序遍历
     */
    public static void inTraversalBinTree(BinaryTreeNode tree){
        if (tree == null)
            return;
        inTraversalBinTree(tree.m_pLeft);
        System.out.print(tree.m_nValue+",");
        inTraversalBinTree(tree.m_pRight);
    }
    /**
     * 二叉树的后序遍历
     */
    public static void postTraversalBinTree(BinaryTreeNode tree){
        if (tree == null)
            return;
        postTraversalBinTree(tree.m_pLeft);
        postTraversalBinTree(tree.m_pRight);
        System.out.print(tree.m_nValue+",");
    }

    /**
     * 主函数，用于测试
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTreeNode tree= rebuildBinaryTree(pre,in);
        System.out.println("先序遍历结果:");
        preTraversalBinTree(tree);
        System.out.println();
        System.out.println("中序遍历结果:");
        inTraversalBinTree(tree);
        System.out.println();
        System.out.println("后序遍历结果:");
        postTraversalBinTree(tree);
    }
}

/*测试结果
先序遍历结果:
1,2,4,7,3,5,6,8,
中序遍历结果:
4,7,2,1,5,3,8,6,
后序遍历结果:
7,4,2,5,8,6,3,1,
Process finished with exit code 0
*/
```

##### 算法思路
前序遍历序列的第一个数字就是根节点的值。扫描中序遍历序列，就能确定根节点的位置。根据中序遍历的特点，在根节点的值前面的值都是左子树的节点值，由于根节点后面的都是右子树的值。在前序遍历和中序遍历序列中划分了左、右子树节点的值之后，我们就可以递归地调用函数去分别构建左、右子树了。

### 面试题8 二叉树的下一个节点
>给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左、右节点的指针，还有一个指向父节点的指针。

##### 测试用例
- 普通二叉树
- 特殊二叉树（所有节点都没有右子节点或左子节点的二叉树；二叉树为空）

##### 实现代码
```
public class interQuestions8 {
    static class BinaryTreeNode{
        String value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        public BinaryTreeNode(String value, BinaryTreeNode left, BinaryTreeNode right, BinaryTreeNode parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * 获取下一个节点的核心方法
     * @param treeNode 当前节点
     * @return 下一个节点或者null
     */
    public static BinaryTreeNode getNext(BinaryTreeNode treeNode){
        if (treeNode == null)
            return null;

        BinaryTreeNode nextNode = null;
        if (treeNode.right != null){
            BinaryTreeNode rNode = treeNode.right;
            while (rNode.left != null){
                rNode = rNode.left;
            }
            nextNode = rNode;
        }else if (treeNode.parent != null){
            BinaryTreeNode current = treeNode;
            BinaryTreeNode parent = treeNode.parent;
            while (parent != null && current == parent.right){
                current = parent;
                parent = current.parent;
            }
            nextNode = parent;
        }
        return nextNode;
    }

    /**
     * main方法用于测试
     * @param args 参数
     */
    public static void main(String[] args) {
        //构造一个二叉树用于测试
        BinaryTreeNode root = new BinaryTreeNode("a",null,null,null);
        root.left = new BinaryTreeNode("b",null,null,root);
        root.right = new BinaryTreeNode("c",null,null,root);
        root.left.left = new BinaryTreeNode("d",null,null,root.left);
        root.left.right = new BinaryTreeNode("e",null,null,root.left);

        BinaryTreeNode node = getNext(root.left);
        //BinaryTreeNode node = getNext(root.left.right);
        //BinaryTreeNode node = getNext(root.right);
        if (node == null)
            System.out.println("该节点是中序遍历的最后一个节点");
        else
        System.out.println("该节点的下一个节点是："+node.value);
    }
}

```

##### 算法思路
分3中情况：一，如果该节点有右子树，那么右子树的最左节点就是下一个节点。二，该节点没有右子树且为父节点的左子节点，那么他的父节点就是下一个节点。三，该节点没有右子树且为父节点的右子节点，那么依次往上遍历，知道找到一个节点是它父节点的左子节点，它的父节点就是下一个节点。

### 面试题9 用两个栈实现队列
>用两个栈实现一个队列。请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。

##### 测试用例
- 往空的队列里添加、删除元素
- 往非空的队列里添加删除元素
- 连续删除元素直至队列为空

##### 实现代码
```
/**
 * 两个栈实现一个队列
 */
public class InterQuestions9 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 在队列尾部插入一个数
     * @param tail 要插入的数字
     */
    public void appendTail(int tail){
        stack1.push(tail);
    }

    /**
     * 删除队列头部的元素
     * @return 删除的元素
     */
    public  int deleteHead() throws Exception {
        if (stack2.empty()){
            if (stack1.empty())
                throw new Exception("queue is empty.");
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        InterQuestions9 queue = new InterQuestions9();
        //queue.deleteHead();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }
}
/* 测试结果
1
2
3
4
 */
```

##### 算法思路
stack1接收输入，如果要从队列删除元素，则先检查Stack2是否为空，不空则直接弹出一个元素。若stack2为空，则判断stack1是否为空，stack1为空，则队列中不存在元素；stack1不空，则依次把stack1中的元素弹出并压入stack2中去，然后stack2弹出一个元素。
