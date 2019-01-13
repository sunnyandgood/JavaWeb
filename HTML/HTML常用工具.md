# HTML常用工具

[Awesome 图标](http://www.runoob.com/font-awesome/fontawesome-tutorial.html)

### 一、使input文本框不可编辑的3种方法
* 1、disabled 属性：规定应该禁用 input 元素，被禁用的 input 元素，不可编辑，不可复制，不可选择，不能接收焦点,后台也不会接收到传值。设置后文字的颜色会变成灰色。disabled 属性无法与 `<input type="hidden">` 一起使用。
  * 示例：
    ```html
    <input type="text" disabled="disabled" />
    ```

* 2、readonly 属性：规定输入字段为只读可复制，但是，用户可以使用Tab键切换到该字段，可选择,可以接收焦点，还可以选中或拷贝其文本。后台会接收到传值. readonly 属性可以**防止用户对值进行修改**。readonly 属性可与 `<input type="text">` 或 `<input type="password">` 配合使用。
  * 示例：
    ```html
    <input type="text" readonly="readonly">
    ```

* 3、`readonly unselectable="on"`： 该属性跟disable类似，input 元素，不可编辑，不可复制，不可选择，不能接收焦点，设置后文字的颜色也会变成灰色，但是后台可以接收到传值。
  * 示例：
    ```html
    <input type="text"  readonly  unselectable="on" >
    ```
### 二、音频播放

* 相对路径：
   ```html
   <audio src="./resources/upload/07718b10-d234-4c8c-8137-348b5639db41.mp3" controls="controls">
      Your browser does not support the audio element.
   </audio>
   ```


* 绝对路径：
   ```html
   <audio src="file:///D:/studyCodes/idea/OnlineMusic/target/com.edu/resources/upload/07718b10-d234-4c8c-8137-348b5639db41.mp3" controls="controls">
       Your browser does not support the audio element.
   </audio>
   ```
