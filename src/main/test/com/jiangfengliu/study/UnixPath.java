package com.jiangfengliu.study;

import java.util.*;

public class UnixPath {
  public String simplifyPath(String path) {
    String[] paths = path.split("/");
    LinkedList<String> stack = new LinkedList<>();
    for (String tmp : paths) {
      if (tmp == null || tmp.equals("") || tmp.equals(".")) {
        continue;
      }
      if (tmp.equals("..")) {
        if (stack.isEmpty()) {
          continue;
        } else {
          stack.pop();
          continue;
        }
      }
      stack.push(tmp);
    }
    if(stack.isEmpty()){
      return "/";
    }
    StringBuffer sb = new StringBuffer();
    for (int i = stack.size()-1; i >=0 ; i--) {
      sb.append("/").append(stack.get(i));
    }
    return sb.toString();
  }

  public String simplifyPath2(String path) {
    String[] paths = path.split("/");

    List<String> listPath = new ArrayList<>();

    for (String p: paths) {
      // System.out.println(":" + p);
      if (p == null || p.equals("") || p.equals(".")) {
        continue;
      }

      if (!p.equals("..")) {
        listPath.add(p);
      } else if (listPath.size() > 0) {
        listPath.remove(listPath.size() - 1);
      }
    }

    if (listPath.size() == 0) {
      return "/";
    }

    StringBuilder res = new StringBuilder();
    for (String p : listPath) {
      res.append("/").append(p);
    }

    return res.toString();
  }

  public static void main(String[] args) {
    String path="/home//foo/";
    //path=path.replaceAll("/{2,}","/");
    System.out.println(path);
    String paths[]=path.split("/");
    System.out.println(Arrays.toString(paths));
    System.out.println(new UnixPath().simplifyPath(path));
  }
}
