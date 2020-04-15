package com.huxl.interview.cmbchina;
//数据库的一致性怎么保证
//1.分组
//2.数据库唯一索引和主键有什么区别
//垃圾收集 JVM

import java.util.*;

/**
 *
 * 牛牛在一个迷宫中，迷宫有  个格子，有  条通道，每条通道连接两个格子 , ，编号为  的格子与编号为  的格子可互相到达，每人每条通道只能走一次。
 *
 * 牛牛想知道，他是否能从  号格子出发回到  号格子。
 *
 * 输入
 * 第一行给定两个整数  ,  。
 *
 * 接下来  行，每行有两个整数 ， 。
 *
 *
 * m对 u, v 互不相同
 *
 * 输出
 * 若能回到  号格子则返回Yes，否则返回No。
 *
 * 考察图的DFS 深度优先遍历，从某个点一直往深处走，不能往下走了之后就回退到上一步，直到所有点都走完或者找到解之后
 * 算法步骤：
 * 1.访问起始点
 * 2.
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] param = {4,4};
        Point[] edge = {getPoint(1,2),getPoint(2,3),getPoint(3,4),getPoint(4,1)};
        System.out.println(solve(param,edge));

    }

    private static Point getPoint(int u,int v){
        Point p = new Point();
        p.x = u;
        p.y = v;
        return p;
    }

    static List<List<Integer>> adjV;
    static boolean[] visit;
    private static boolean search(int cur,int pre){
        if (cur == 0) {
            return true;
        }
        if (visit[cur]) {
            return false;
        }
        visit[cur] = true;
        for (int next : adjV.get(cur)){
            if (next == pre) {
                continue;
            }
            if (search(next,cur)){
                return true;
            }
        }
        return false;

    }

    public static String solve (int[] param, Point[] edge) {
        //度
        List<Integer>  indegree = new ArrayList<>();
        List<List<Integer>> table = new ArrayList<>();
        int n = param[0];
        int m = param[1];
        for (int i = 0; i < n; i++) {
            indegree.add(0);
            List<Integer> tem = new ArrayList<>();
            table.add(tem);
        }
        Point p;
        for (int i = 0; i < edge.length; i++) {
            p = edge[i];
            table.get(p.x-1).add(p.y-1);
            table.get(p.y -1).add(p.x-1);
            indegree.set(p.y-1,indegree.get(p.y-1) + 1);
            indegree.set(p.x-1,indegree.get(p.x-1) + 1);
        }
        int num = indegree.get(0);
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) <= 1){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int k = q.getFirst();
            if (k == 1) return "No";
            q.pop();
            List<Integer> nodes = table.get(k);
            for (int i = 0; i < nodes.size(); i++) {
                int s = nodes.get(i);
                indegree.set(s,indegree.get(s)-1);
                if (indegree.get(s) == 1) {
                    if (s == 1) {
                        return "No";
                    }
                    q.push(s);
                }
            }

        }
        return "Yes";
    }

}

class Point{
    int x;
    int y;
}
