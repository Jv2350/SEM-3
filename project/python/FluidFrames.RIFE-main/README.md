<div align="center">
    <br>
    <img src="https://user-images.githubusercontent.com/32263112/216588514-0ad68175-c65e-47ee-9ca8-d163572d9be9.png" width="175"> </a> 
    <br><br>FluidFrames.RIFE | video AI interpolation app (RIFE-HDv3) <br><br>
    <a href="https://jangystudio.itch.io/fluidframesrife">
         <img src="https://user-images.githubusercontent.com/86362423/162710522-c40c4f39-a6b9-48bc-84bc-1c6b78319f01.png" width="200">
    </a>
</div>
<br>
<div align="center">
    <img src="https://github.com/Djdefrag/FluidFrames.RIFE/assets/32263112/7f9d64a8-6362-4973-af34-8a102003437d"> </a> 
</div>

## What is FluidFrames.RIFE?

FluidFrames.RIFE is a Windows app powered by RIFE-HDv3 AI to fluidify videos and to create slowmotion videos.

## Other AI projects.🤓

- https://github.com/Djdefrag/QualityScaler / QualityScaler - image/video AI upscaler app (BSRGAN)
- https://github.com/Djdefrag/RealESRScaler / RealESRScaler - image/video AI upscaler app (Real-ESRGAN)

## Credits.

RIFE - https://github.com/megvii-research/ECCV2022-RIFE

## How is made. 🛠

FluidFrames.RIFE is completely written in Python, from backend to frontend.
External packages are:

- AI  -> torch / torch-directml
- GUI -> customtkinter
- Image/video -> openCV / moviepy
- Packaging   -> pyinstaller / upx

## Requirements. 🤓

- [ ] Windows 11 / Windows 10
- [ ] RAM >= 8Gb
- [ ] Any Directx12 compatible GPU with >= 2GB VRAM

## Features.

- [X] Easy to use GUI
- [X] Video frames interpolation x2 / x4
  - 30fps => x2 => 60fps
  - 30fps => x4 => 120fps
- [X] Video slowmotion x2 /x4
  - 30fps => x2_slowmotion => 30fps - 2 times slower
  - 30fps => x4_slowmotion => 30fps - 4 times slower
- [X] Resize video before interpolation
- [X] Multiple gpu backend
- [X] Compatible video  - mp4, wemb, gif, mkv, flv, avi, mov, qt

## Next steps. 🤫

- [ ] 1.X versions
  - [X] Switch to Pytorch-directml to support all Directx12 compatible gpu (AMD, Intel, Nvidia)
  - [X] New GUI with Windows 11 style
  - [X] Include audio for processed video
  - [X] Optimizing video frame resize and extraction speed
  - [X] Multi GPU support (for pc with double GPU, integrated + dedicated)
  - [X] Python 3.10 (expecting ~10% more performance)
  - [X] Slowmotion function
- [ ] 2.X versions (now under development)
  - [X] New, completely redesigned graphical interface based on @customtkinter
  - [X] Fluidify multiple videos at once
  - [ ] Python 3.11 (expecting ~30% more performance)
  - [ ] Torch/torch-directml 2.0 (expecting ~20% more performance)

### Some Examples.

#### Videos

1. Original / x4 / x4-slomotion

https://user-images.githubusercontent.com/32263112/235297757-5daf129e-4e19-4b8b-b6c8-b661ac1028db.mp4

https://user-images.githubusercontent.com/32263112/235297763-26bf9fdd-3d40-4aba-8688-5ef85a532ed0.mp4

https://user-images.githubusercontent.com/32263112/235297767-0adc4635-a43e-4c37-bd15-a24e1dd47f32.mp4

2. Original / x2

https://user-images.githubusercontent.com/32263112/222885925-a28122e8-92f8-4e53-b287-4ae17bb177c7.mp4

https://user-images.githubusercontent.com/32263112/222885933-f2e13869-984c-4192-8020-1668035e5cd3.mp4

3. Original / x2

![209639439-94c8774d-354e-4d56-9123-e1aa4af95e08](https://user-images.githubusercontent.com/32263112/221165591-3a0fb780-3ba8-4cf5-8405-fc83eb58ee66.gif)

https://user-images.githubusercontent.com/32263112/221165739-71dfd957-5d3d-481b-9a26-bb08d5affa6f.mp4

4. Original / x2 / x2-slomotion

https://user-images.githubusercontent.com/32263112/228229016-8b26c8f3-8a68-4b5e-b1ff-d52f9be76a03.mp4

https://user-images.githubusercontent.com/32263112/228229044-9d267a66-543e-43ca-890b-db6a70c29d0b.mp4

https://user-images.githubusercontent.com/32263112/228229083-d29a313f-3d28-4cdb-9d97-63410f28a608.mp4
