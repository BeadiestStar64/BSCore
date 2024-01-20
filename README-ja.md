# BSCoreとは?
BSCoreプラグインは
- ファイル作成
- 翻訳ファイルに基づく翻訳
- yamlファイルの読み書き

の機能を備えたSpigotプラグインです。  
BSCoreプラグインは軽量ながら、幅広い互換性と高速な動作を特徴としています。

# 開発者向け
BSCoreは**FileManager、Translate、YamlReader**クラスで構成されています。  
<details>
  <summary>FileManager</summary>

  createFileメソッドの他に任意のtxtから一括でファイルを作成するinitメソッドが実行できます。

  例. RequestFiles.txtを用いてconfig.yml、yml/permission.ymlを作成  
  ```txt
  #Folder Name, File Name
  config.yml
  yml, permission.yml
  ```

  任意のtxtファイルを使用する場合、#を行頭に付けることでコメントとできます。
</details>

> [!CAUTION]
> コードの関係上、必ずtxtファイルはフォルダ名、ファイル名としてください。
