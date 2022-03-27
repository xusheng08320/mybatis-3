package org.apache.ibatis.demo;

import org.apache.ibatis.reflection.Reflector;
import org.junit.Test;

/**
 * @Author xusheng
 * @Date 2022/3/27 1:59 PM
 * @Desc
 */
public class ReflectTest {

    @Test
    public void testReflection() {
        Reflector reflector = new Reflector(InnerReflectorClass.class);
        System.out.println(reflector.hasSetter("name1"));
    }

    class InnerReflectorClass {
        private int age;

        private String name;

        private String field1;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getField(){
            return null;
        }
    }
}
