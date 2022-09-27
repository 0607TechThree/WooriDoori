new Vue({
  el: "#app",
  data() {
    return {
      audio: null,
      circleLeft: null,
      barWidth: null,
      duration: null,
      currentTime: null,
      isTimerPlaying: false,
      tracks: [
        {
          name: "Square (2017)",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10362776_20191210144641_500.jpg",
          source: "mp3/백예린 (Yerin Baek) - 'Square (2017)' (Official Lyric Video).mp3",
          url: "https://www.youtube.com/watch?v=o-8FEX5dXKc",
          favorited: false
        },
        {
          name: "그건 아마 우리의 잘못은 아닐 거야",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10262378_500.jpg",
          source: "mp3/그건 아마 우리의 잘못은 아닐 거야 Maybe It’s Not Our Fault.mp3",
          url: "https://www.youtube.com/watch?v=Vxu04u4dzO4",
          favorited: false
        },
        {
          name: "물고기",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10964906_20220523165114_500.jpg",
          source: "mp3/[Official Audio] 백예린 (Yerin Baek) - 물고기 (Pisces).mp3",
          url: "https://www.youtube.com/watch?v=DNf6mIZz6Zo",
          favorited: false
        },
        {
          name: "우주를 건너",
          artist: "백예린 (Yerin Baek)",
          cover: "img/2653573_500.jpg",
          source: "mp3/백예린 - 우주를 건너 가사 lyrics.mp3",
          url: "https://www.youtube.com/watch?v=cQuqs2LrXbo",
          favorited: false
        },
        {
          name: "산책",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10710311_20210909184021_500.jpg",
          source: "mp3/백예린 - 산책   가사.mp3",
          url: "https://www.youtube.com/watch?v=iAeeTin1uCA",
          favorited: false
        },
        {
          name: "0310",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10362776_20191210144641_500.jpg",
          source: "mp3/백예린 (Yerin Baek) - 0310   가사.mp3",
          url: "https://www.youtube.com/watch?v=jpcxOcE4vRo",
          favorited: false
        },
        {
          name: "야간비행 (魔女の花)",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10262378_500.jpg",
          source: "mp3/Yerin Baek (백예린) – Merry and the Witch’s Flower (야간비행 (魔女の花)) (Han Rom Eng) Lyrics 한국어 가사.mp3",
          url: "https://www.youtube.com/watch?v=SVKC0Tvi3cM",
          favorited: false
        },
        {
          name: "Hate you",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10532062_20201210145521_500.jpg",
          source: "mp3/백예린 (Yerin Baek) 'Hate you' Lyrics (백예린 Hate You 가사).mp3",
          url: "https://www.youtube.com/watch?v=Sh4eEyEEb98",
          favorited: false
        },
        {
          name: "Antifreeze",
          artist: "백예린 (Yerin Baek)",
          cover: "img/10710311_20210909184021_500.jpg",
          source: "mp3/백예린 (Yerin Baek) - Antifreeze   가사.mp3",
          url: "https://www.youtube.com/watch?v=jq791XgtZVEhttps://www.youtube.com/watch?v=jq791XgtZVE",
          favorited: false
        },
		{
		name: "그때 그 순간 그대로 (그그그)",
		artist: "WSG워너비 (가야G)",
        cover: "img/11000171_20220708163659_500.jpg",
        source: "mp3/WSG워너비 (가야G) - 그때 그 순간 그대로 (그그그)   가사.mp3",
        url: "https://www.youtube.com/watch?v=kZvzjX35KxY",
        avorited: false

		}
      ],
      currentTrack: null,
      currentTrackIndex: 0,
      transitionName: null
    };
  },
  methods: {
    play() {
      if (this.audio.paused) {
        this.audio.play();
        this.isTimerPlaying = true;
      } else {
        this.audio.pause();
        this.isTimerPlaying = false;
      }
    },
    generateTime() {
      let width = (100 / this.audio.duration) * this.audio.currentTime;
      this.barWidth = width + "%";
      this.circleLeft = width + "%";
      let durmin = Math.floor(this.audio.duration / 60);
      let dursec = Math.floor(this.audio.duration - durmin * 60);
      let curmin = Math.floor(this.audio.currentTime / 60);
      let cursec = Math.floor(this.audio.currentTime - curmin * 60);
      if (durmin < 10) {
        durmin = "0" + durmin;
      }
      if (dursec < 10) {
        dursec = "0" + dursec;
      }
      if (curmin < 10) {
        curmin = "0" + curmin;
      }
      if (cursec < 10) {
        cursec = "0" + cursec;
      }
      this.duration = durmin + ":" + dursec;
      this.currentTime = curmin + ":" + cursec;
    },
    updateBar(x) {
      let progress = this.$refs.progress;
      let maxduration = this.audio.duration;
      let position = x - progress.offsetLeft;
      let percentage = (100 * position) / progress.offsetWidth;
      if (percentage > 100) {
        percentage = 100;
      }
      if (percentage < 0) {
        percentage = 0;
      }
      this.barWidth = percentage + "%";
      this.circleLeft = percentage + "%";
      this.audio.currentTime = (maxduration * percentage) / 100;
      this.audio.play();
    },
    clickProgress(e) {
      this.isTimerPlaying = true;
      this.audio.pause();
      this.updateBar(e.pageX);
    },
    prevTrack() {
      this.transitionName = "scale-in";
      this.isShowCover = false;
      if (this.currentTrackIndex > 0) {
        this.currentTrackIndex--;
      } else {
        this.currentTrackIndex = this.tracks.length - 1;
      }
      this.currentTrack = this.tracks[this.currentTrackIndex];
      this.resetPlayer();
    },
    nextTrack() {
      this.transitionName = "scale-out";
      this.isShowCover = false;
      if (this.currentTrackIndex < this.tracks.length - 1) {
        this.currentTrackIndex++;
      } else {
        this.currentTrackIndex = 0;
      }
      this.currentTrack = this.tracks[this.currentTrackIndex];
      this.resetPlayer();
    },
    resetPlayer() {
      this.barWidth = 0;
      this.circleLeft = 0;
      this.audio.currentTime = 0;
      this.audio.src = this.currentTrack.source;
      setTimeout(() => {
        if(this.isTimerPlaying) {
          this.audio.play();
        } else {
          this.audio.pause();
        }
      }, 300);
    },
    favorite() {
      this.tracks[this.currentTrackIndex].favorited = !this.tracks[
        this.currentTrackIndex
      ].favorited;
    }
  },
  created() {
    let vm = this;
    this.currentTrack = this.tracks[0];
    this.audio = new Audio();
    this.audio.src = this.currentTrack.source;
    this.audio.ontimeupdate = function() {
      vm.generateTime();
    };
    this.audio.onloadedmetadata = function() {
      vm.generateTime();
    };
    this.audio.onended = function() {
      vm.nextTrack();
      this.isTimerPlaying = true;
    };

    // this is optional (for preload covers)
    for (let index = 0; index < this.tracks.length; index++) {
      const element = this.tracks[index];
      let link = document.createElement('link');
      link.rel = "prefetch";
      link.href = element.cover;
      link.as = "image"
      document.head.appendChild(link)
    }
  }
  
});